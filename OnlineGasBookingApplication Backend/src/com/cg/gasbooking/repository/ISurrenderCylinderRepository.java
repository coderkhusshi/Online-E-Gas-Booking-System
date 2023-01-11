package com.cg.gasbooking.repository;

import com.cg.gasbooking.entity.SurrenderCylinder;
import com.cg.gasbooking.exception.SurrenderCylinderNotFoundException;

public interface ISurrenderCylinderRepository {
	public SurrenderCylinder insertSurrenderCylinder(SurrenderCylinder surrenderCylinder) throws SurrenderCylinderNotFoundException;
	public SurrenderCylinder updateSurrenderCylinder(SurrenderCylinder surrenderCylinder) throws SurrenderCylinderNotFoundException;
	public SurrenderCylinder deleteSurrenderCylinder(int surrenderCylinderId);
	public int countSurrenderedCylinders();
}