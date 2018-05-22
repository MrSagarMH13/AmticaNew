package com.amtica.hrms.institute;

public interface InstituteService {

	public InstituteDTO addInstitute(InstituteDTO instituteDTO);

	public InstituteDTO getByInstistuteId(Integer instituteId);

	public InstituteDTO updateInstitute(InstituteDTO dto);

	public InstituteDTO deleteInstitute(Integer instituteId, boolean isDeleted);
}
