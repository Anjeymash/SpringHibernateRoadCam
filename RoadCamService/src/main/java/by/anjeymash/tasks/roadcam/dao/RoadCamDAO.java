package by.anjeymash.tasks.roadcam.dao;

import java.util.List;

import by.anjeymash.tasks.roadcam.model.Registration;

public interface RoadCamDAO {
	public List<Registration> getRegistrations();

	public Registration addRegistration(Registration reg);

	public List<Registration> getRegistrationsForNum(String num);

	public int getAllRegCount();
}
