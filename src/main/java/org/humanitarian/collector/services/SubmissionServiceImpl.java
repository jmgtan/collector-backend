package org.humanitarian.collector.services;

import org.humanitarian.collector.controllers.requests.AttachmentRequest;
import org.humanitarian.collector.controllers.requests.BarangayPersonRequest;
import org.humanitarian.collector.controllers.requests.BarangayRequest;
import org.humanitarian.collector.controllers.requests.DemographicRequest;
import org.humanitarian.collector.models.*;
import org.humanitarian.collector.repositories.BarangayRepository;
import org.humanitarian.collector.repositories.DataAttachmentRepository;
import org.humanitarian.collector.repositories.DemographicRepository;
import org.humanitarian.collector.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;

@Service
public class SubmissionServiceImpl implements SubmissionService {

    @Autowired
    private DemographicRepository demographicRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private BarangayRepository barangayRepository;

    @Autowired
    private DataAttachmentRepository dataAttachmentRepository;

    @Override
    @Transactional
    public Barangay saveBarangayRequest(BarangayRequest request) {
        Barangay b = new Barangay();

        for (BarangayPersonRequest perRequest : request.getPeople()) {
            b.addPerson(checkOrCreatePersonFromRequest(perRequest));
        }

        b.setFoodProductionActivity(request.getFoodProductionActivity());
        b.setTreesInVicinity(request.getTreesInVicinity());
        b.setTypeOfToilet(request.getTypeOfToilet());
        b.setLivelihoodEquipment(request.getLivelihoodEquipment());
        b.setMembers(request.getMembers());
        b.setTenure(request.getTenure());
        b.setFortifiedFood(request.isConsumingFortifiedFood());
        b.setGarbageDisposal(request.getGarbageDisposal());
        b.setResidenceAddress(request.getResidenceAddress());
        b.setWaterSource(request.getWaterSource());
        b.setHouseLevel(request.getHouseLevel());
        b.setIodizedSalt(request.isConsumedIodizedSalt());
        b.setHouseholdNumber(request.getHouseholdNumber());
        b.setDwelling(request.getDwelling());
        b.setSourceSystem(request.getSourceSystem());
        b.setSourceSystemIdentifier(request.getSourceSystemIdentifier());

        barangayRepository.save(b);

        if (request.getAttachments() != null) {
            for (AttachmentRequest attachmentRequest : request.getAttachments()) {
                DataAttachment dataAttachment = new DataAttachment();
                dataAttachment.setDownloadSmallUrl(attachmentRequest.getDownloadSmallUrl());
                dataAttachment.setDownloadLargeUrl(attachmentRequest.getDownloadLargeUrl());
                dataAttachment.setDownloadUrl(attachmentRequest.getDownloadUrl());
                dataAttachment.setDownloadMediumUrl(attachmentRequest.getDownloadMediumUrl());
                dataAttachment.setMimeType(attachmentRequest.getMimeType());
                dataAttachment.setFilename(attachmentRequest.getFilename());
                dataAttachment.setReportData(b);
                dataAttachmentRepository.save(dataAttachment);

                b.addDataAttachment(dataAttachment);
            }
        }

        return b;
    }

    @Override
    @Transactional
    public Person checkOrCreatePersonFromRequest(BarangayPersonRequest request) {
        Person p = personRepository.findOneByFirstNameAndMiddleNameAndLastNameAndDob(request.getFirstName(), request.getMiddleName(), request.getLastName(), request.getDob());

        if (p == null) {
            p = new Person();
            p.setFirstName(request.getFirstName());
            p.setMiddleName(request.getMiddleName());
            p.setLastName(request.getLastName());
            p.setDob(request.getDob());
        }

        p.setMemberOfLgbtqi(request.isMemberOfLgbtqiCommunity());
        p.setBreastfeeding(request.getBreastfeeding());
        p.setOthersBreastfeeding(request.getOthersBreastfeeding());
        p.setReceivedGovernmentProgram(request.getReceivedGovernmentPrograms());
        p.setPregnant(request.isPregnant());
        p.setFamilyPlanning(request.isPracticingFamilyPlanning());
        p.setDisability(request.getDisability());
        p.setGender(request.getSex());
        p.setRelationship(request.getRelationship());
        p.setCivilStatus(request.getCivilStatus());
        p.setHighestEducationalAttainment(request.getHighestEducationalAttainment());
        p.setOthersEducationalAttainment(request.getOtherHighestEducationalAttainment());
        p.setPlaceOfBirth(request.getPlaceOfBirth());
        p.setIpAffiliation(request.getIpAffiliation());
        p.setBloodType(request.getBloodType());
        p.setOccupation(request.getOccupation());

        personRepository.save(p);

        return p;
    }

    @Override
    @Transactional
    public Demographic saveDemographicRequest(DemographicRequest request) {
        return saveDemographicWithBatch(request, null);
    }

    @Override
    @Transactional
    public Demographic saveDemographicWithBatch(DemographicRequest request, BatchDataFile batchDataFile) {
        Person person = checkOrCreatePerson(request.getFirstName(), request.getLastName(), request.getDateOfBirth());

        Demographic d = new Demographic();

        d.addPerson(person);
        d.setAddress(request.getAddress());
        d.setSubmissionTime(request.getSubmissionTime());
        d.setSourceSystem(request.getSourceSystem());
        d.setSourceSystemIdentifier(request.getSourceFormId());
        d.setTelephoneNumber(request.getTelephoneNumber());
        d.setBatchDataFile(batchDataFile);

        demographicRepository.save(d);

        if (request.getAttachments() != null) {
            for (AttachmentRequest attachmentRequest : request.getAttachments()) {
                DataAttachment dataAttachment = new DataAttachment();
                dataAttachment.setDownloadSmallUrl(attachmentRequest.getDownloadSmallUrl());
                dataAttachment.setDownloadLargeUrl(attachmentRequest.getDownloadLargeUrl());
                dataAttachment.setDownloadUrl(attachmentRequest.getDownloadUrl());
                dataAttachment.setDownloadMediumUrl(attachmentRequest.getDownloadMediumUrl());
                dataAttachment.setMimeType(attachmentRequest.getMimeType());
                dataAttachment.setFilename(attachmentRequest.getFilename());
                dataAttachment.setReportData(d);
                dataAttachmentRepository.save(dataAttachment);

                d.addDataAttachment(dataAttachment);
            }
        }

        return d;
    }

    @Override
    @Transactional
    public Person checkOrCreatePerson(String firstName, String lastName, Date dob) {
        Person person = personRepository.findOneByFirstNameAndLastNameAndDob(firstName, lastName, dob);

        if (person == null) {
            person = new Person();
            person.setFirstName(firstName);
            person.setLastName(lastName);
            person.setDob(dob);

            personRepository.save(person);
        }

        return person;
    }
}
