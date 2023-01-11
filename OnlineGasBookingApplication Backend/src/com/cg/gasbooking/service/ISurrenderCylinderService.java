package com.cg.gasbooking.service;

import com.cg.gasbooking.entity.SurrenderCylinder;

public interface ISurrenderCylinderService {
	public SurrenderCylinder insertSurrenderCylinder(SurrenderCylinder surrenderCylinder);
	public SurrenderCylinder updateSurrenderCylinder(SurrenderCylinder surrenderCylinder);
	public SurrenderCylinder deleteSurrenderCylinder(int surrenderCylinderId);
	public int countSurrenderedCylinders();
}