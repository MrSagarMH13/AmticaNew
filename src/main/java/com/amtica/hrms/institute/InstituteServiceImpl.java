package com.amtica.hrms.institute;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstituteServiceImpl implements InstituteService {
	
	@Autowired
	InstituteRepository instituteRepo;
	
	@Override
	public InstituteDTO addInstitute(InstituteDTO instituteDTO) {
		// TODO Auto-generated method stub		
		
		Institute institute = InstituteMapper.mapToModel(instituteDTO);
		institute = instituteRepo.save(institute);
		return instituteDTO;
	}

	@Override
	public InstituteDTO getByInstistuteId(Integer instituteId) {
		// TODO Auto-generated method stub
		InstituteDTO institute = InstituteMapper.mapToDTO(instituteRepo.findByInstituteId(instituteId));
		return institute;
	}

	
	@Override
	public InstituteDTO updateInstitute(InstituteDTO dto) {
		// TODO Auto-generated method stub
		Institute institute = instituteRepo.findByInstituteId(dto.getInstituteId());
		institute = InstituteMapper.mapToModel(dto,institute);
		institute = instituteRepo.saveAndFlush(institute);
		InstituteDTO instituteDTO = InstituteMapper.mapToDTO(institute);
				
				
		
		return instituteDTO;
	}

	@Override
	public InstituteDTO deleteInstitute(Integer instituteId, boolean isDeleted) {
		// TODO Auto-generated method stub
		
		InstituteDTO instituteDTO = null;
		Optional<Institute> optional = instituteRepo.findById(instituteId);
		if(optional.isPresent()){
			
			Institute deleted = optional.get();
			deleted.setIsDeleted(isDeleted);
			instituteRepo.saveAndFlush(deleted);
			
			instituteDTO = InstituteMapper.mapToDTO(deleted);
			
		}
		
		return instituteDTO;
	}

}
