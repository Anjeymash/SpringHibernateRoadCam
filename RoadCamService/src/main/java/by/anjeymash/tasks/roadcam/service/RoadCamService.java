package by.anjeymash.tasks.roadcam.service;

import java.util.List;

import by.anjeymash.tasks.roadcam.dao.RoadCamDAO;
import by.anjeymash.tasks.roadcam.model.Registration;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
@Transactional(readOnly = true)
@Path("/registrations")
public class RoadCamService {

	private RoadCamDAO roadCamDAO;

	@Autowired(required = true)
	@Qualifier(value = "roadCamDAO")
	public void setRoadCamDAO(RoadCamDAO roadCamDAO) {
		this.roadCamDAO = roadCamDAO;
	}

	// URI:
	// /contextPath/servletPath/registrations
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Registration> getRegistrations() {
		return roadCamDAO.getRegistrations();

	}

	// URI:
	// /contextPath/servletPath/registrations/{regNum}
	@GET
	@Path("/{regNum}")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Registration> getRegistrationsForNum(@PathParam("regNum") String regNum) {
		return roadCamDAO.getRegistrationsForNum(regNum);

	}

	// URI:
	// /contextPath/servletPath/registrations
	@Transactional
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	public Registration addRegistration(Registration reg) {
		return roadCamDAO.addRegistration(reg);
	}

	// URI:
	// /contextPath/servletPath/registrations/stats/count
	@GET
	@Path("/stats/count")
	@Produces({ MediaType.APPLICATION_JSON })
	public String getAllRegCount() {
		int count = roadCamDAO.getAllRegCount();
		return Integer.toString(count);
	}

}
