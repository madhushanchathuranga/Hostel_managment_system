package com.example.hostal.Service;

public class ComplaintServiceImpl {
    @Autowired
    private ComplaintRepository complaintRepository;

    public ComplaintServiceImpl(ComplaintRepository complaintRepository){
        super();
        this.complaintRepository=complaintRepository;
    }
    @Override
    public  Complaint saveComplaint(Complaint complaint) {
        return complaintRepository.save(complaint);
    }
    @Override
    public Iterable<Complaint> getAllComplaint() {
        return (List<Complaint>) complaintRepository.findAll();
    }


    @Override
    public Complaint getComplaintById(Long id) {
        Optional<Complaint> complaintOptional = complaintRepository.findById(id);
        return complaintOptional.orElse(null);
    }
}
