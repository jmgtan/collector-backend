package org.humanitarian.collector.services;

import org.humanitarian.collector.controllers.requests.AttachmentRequest;
import org.humanitarian.collector.controllers.requests.BarangayPersonRequest;
import org.humanitarian.collector.controllers.requests.BarangayFormDataRequest;
import org.humanitarian.collector.controllers.requests.DemographicFormDataRequest;
import org.humanitarian.collector.models.*;
import org.humanitarian.collector.repositories.BarangayFormDataRepository;
import org.humanitarian.collector.repositories.DataAttachmentRepository;
import org.humanitarian.collector.repositories.DemographicFormDataRepository;
import org.humanitarian.collector.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class SubmissionServiceImpl implements SubmissionService {

    @Autowired
    private DemographicFormDataRepository demographicFormDataRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private BarangayFormDataRepository barangayFormDataRepository;

    @Autowired
    private DataAttachmentRepository dataAttachmentRepository;

    @Override
    @Transactional
    public List<BarangayFormData> saveBarangayFormDataRequest(BarangayFormDataRequest request) {
        List<BarangayFormData> entities = new ArrayList<>(request.getPeople().size() + 1);

        for (BarangayPersonRequest perRequest : request.getPeople()) {
            BarangayFormData b = new BarangayFormData();
            b.setPerson(checkOrCreatePersonFromRequest(perRequest));
            b.addFoodProductionActivities(request.getFoodProductionActivity());
            b.addTreeInVicinity(request.getTreesInVicinity());
            b.addTypesOfToilet(request.getTypeOfToilet());
            b.addLivelihoodEquipments(request.getLivelihoodEquipment());
            b.setMembers(request.getMembers());
            b.setTenure(request.getTenure());
            b.setFortifiedFood(request.isConsumingFortifiedFood());
            b.addGarbageDisposals(request.getGarbageDisposal());
            b.setResidenceAddress(request.getResidenceAddress());
            b.addWaterSources(request.getWaterSource());
            b.setHouseLevel(request.getHouseLevel());
            b.setIodizedSalt(request.isConsumedIodizedSalt());
            b.setHouseholdNumber(request.getHouseholdNumber());
            b.setDwelling(request.getDwelling());
            b.setSourceSystem(request.getSourceSystem());
            b.setSourceSystemIdentifier(request.getSourceSystemIdentifier());

            barangayFormDataRepository.save(b);

            if (request.getAttachments() != null) {
                for (AttachmentRequest attachmentRequest : request.getAttachments()) {
                    DataAttachment dataAttachment = new DataAttachment();
                    dataAttachment.setDownloadSmallUrl(attachmentRequest.getDownloadSmallUrl());
                    dataAttachment.setDownloadLargeUrl(attachmentRequest.getDownloadLargeUrl());
                    dataAttachment.setDownloadUrl(attachmentRequest.getDownloadUrl());
                    dataAttachment.setDownloadMediumUrl(attachmentRequest.getDownloadMediumUrl());
                    dataAttachment.setMimeType(attachmentRequest.getMimeType());
                    dataAttachment.setFilename(attachmentRequest.getFilename());
                    dataAttachment.setFormData(b);
                    dataAttachmentRepository.save(dataAttachment);

                    b.addDataAttachment(dataAttachment);
                }
            }

            entities.add(b);
        }

        return entities;
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
        p.addGovernmentPrograms(request.getReceivedGovernmentPrograms());
        p.setPregnant(request.isPregnant());
        p.setFamilyPlanning(request.isPracticingFamilyPlanning());
        p.addDisabilities(request.getDisability());
        p.setGender(request.getSex());
        p.setRelationship(request.getRelationship());
        p.setCivilStatus(request.getCivilStatus());
        p.setHighestEducationalAttainment(request.getHighestEducationalAttainment());
        p.setOthersEducationalAttainment(request.getOtherHighestEducationalAttainment());
        p.setPlaceOfBirth(request.getPlaceOfBirth());
        p.addIpAffiliations(request.getIpAffiliation());
        p.setBloodType(request.getBloodType());
        p.setOccupation(request.getOccupation());
        p.addFamilyPlanningMethods(request.getFamilyPlanningMethod());

        personRepository.save(p);

        return p;
    }

    @Override
    @Transactional
    public DemographicFormData saveDemographicFormDataRequest(DemographicFormDataRequest request) {
        return saveDemographicFormDataWithBatch(request, null);
    }

    @Override
    @Transactional
    public DemographicFormData saveDemographicFormDataWithBatch(DemographicFormDataRequest request, BatchDataFile batchDataFile) {
        Person person = checkOrCreatePerson(request.getFirstName(), request.getLastName(), request.getDateOfBirth());

        DemographicFormData d = new DemographicFormData();

        d.setPerson(person);
        d.setAddress(request.getAddress());
        d.setSubmissionTime(request.getSubmissionTime());
        d.setSourceSystem(request.getSourceSystem());
        d.setSourceSystemIdentifier(request.getSourceFormId());
        d.setTelephoneNumber(request.getTelephoneNumber());
        d.setBatchDataFile(batchDataFile);

        demographicFormDataRepository.save(d);

        if (request.getAttachments() != null) {
            for (AttachmentRequest attachmentRequest : request.getAttachments()) {
                DataAttachment dataAttachment = new DataAttachment();
                dataAttachment.setDownloadSmallUrl(attachmentRequest.getDownloadSmallUrl());
                dataAttachment.setDownloadLargeUrl(attachmentRequest.getDownloadLargeUrl());
                dataAttachment.setDownloadUrl(attachmentRequest.getDownloadUrl());
                dataAttachment.setDownloadMediumUrl(attachmentRequest.getDownloadMediumUrl());
                dataAttachment.setMimeType(attachmentRequest.getMimeType());
                dataAttachment.setFilename(attachmentRequest.getFilename());
                dataAttachment.setFormData(d);
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
