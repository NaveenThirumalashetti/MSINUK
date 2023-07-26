package com.msinuk.main.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.msinuk.main.model.UniversityDetails;
import com.msinuk.main.model.UniversityDetails_;
import com.msinuk.main.repository.UniversityDetailsRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.MapJoin;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Service
public class UniversityService {


	@Autowired
	private UniversityDetailsRepo universityRepo;
	
	@PersistenceContext
    private EntityManager entityManager;

	public List<UniversityDetails> getUniversities() {
		return this.universityRepo.findAllByOrderByRatingDesc();
	}
	public List<UniversityDetails> getWishList(String ids) {
		String[] idArr = ids.split(",");
		List<Long> idList = new ArrayList<>();
		for(String id :idArr) {
			idList.add(Long.parseLong(id));
		}
		return this.universityRepo.findAllById(idList);
	}
	public List<UniversityDetails> addUniversities() throws JsonMappingException, JsonProcessingException {
	
		String jSon ="{\r\n"
				+ "  \"Accounting and Finance\": [\r\n"
				+ "    \"Actuarial Management MSc\",\r\n"
				+ "    \"Actuarial Science MSc\",\r\n"
				+ "    \"Corporate Finance MSc\",\r\n"
				+ "    \"Finance MSc\",\r\n"
				+ "    \"Financial Economics MSc\",\r\n"
				+ "    \"Financial Mathematics MSc\",\r\n"
				+ "    \"Shipping, Trade and Finance MSc\"\r\n"
				+ "  ],\r\n"
				+ "  \"Arts\": [\r\n"
				+ "    \"Composition MA\"\r\n"
				+ "  ],\r\n"
				+ "  \"Business Administration\": [\r\n"
				+ "    \"Insurance and Risk Management MSc; MA; MInnov\",\r\n"
				+ "    \"Modular Executive MBA Programme in London\"\r\n"
				+ "  ],\r\n"
				+ "  \"Business and Management\": [\r\n"
				+ "    \"Banking and International Finance MSc\",\r\n"
				+ "    \"Business Analytics MSc\",\r\n"
				+ "    \"Charity Accounting and Financial Management MSc\",\r\n"
				+ "    \"Charity Marketing and Fundraising MSc\",\r\n"
				+ "    \"Digital Supply Chain Management MSc\",\r\n"
				+ "    \"Entrepreneurship MSc\",\r\n"
				+ "    \"Executive MBA\",\r\n"
				+ "    \"Executive MBA in Dubai\",\r\n"
				+ "    \"Insurance and Risk Management MSc\",\r\n"
				+ "    \"Management MSc\"\r\n"
				+ "  ],\r\n"
				+ "  \"Computing and Information Systems\": [\r\n"
				+ "    \"Computer Games Technology MSc\",\r\n"
				+ "    \"Information Systems and Technology MSc\",\r\n"
				+ "    \"Internet of Things with Entrepreneurship MSc\",\r\n"
				+ "    \"Software Engineering MSc\"\r\n"
				+ "  ],\r\n"
				+ "  \"Economics\": [\r\n"
				+ "    \"Behavioural Economics MSc\",\r\n"
				+ "    \"Business Economics/International Business Economics MSc\",\r\n"
				+ "    \"Development Economics MSc\",\r\n"
				+ "    \"Economics MSc\"\r\n"
				+ "  ],\r\n"
				+ "  \"Education and Teaching\": [\r\n"
				+ "    \"Academic Practice MA\"\r\n"
				+ "  ],\r\n"
				+ "  \"Engineering\": [\r\n"
				+ "    \"Aerospace Engineering MEng (Hons)\"\r\n"
				+ "  ],\r\n"
				+ "  \"English Language and Literature\": [\r\n"
				+ "    \"Creative Writing MFA\"\r\n"
				+ "  ],\r\n"
				+ "  \"Global Media and Digital Cultures\": [\r\n"
				+ "    \"Media and Communications MA\"\r\n"
				+ "  ],\r\n"
				+ "  \"Health\": [\r\n"
				+ "    \"Adult Nursing (pre-registration) MSc\",\r\n"
				+ "    \"Advanced Clinical Practice MSc\",\r\n"
				+ "    \"Children's Nursing (pre-registration) MSc\",\r\n"
				+ "    \"Leading Integrated Care MSc\",\r\n"
				+ "    \"Adult and Mental Health Nursing (pre-registration) MSc\",\r\n"
				+ "    \"Adult Mental Health (Contemporary Studies) MSc\",\r\n"
				+ "    \"Clinical Optometry MSc\",\r\n"
				+ "    \"Medical Ultrasound MSc/Postgrad Diploma/Postgrad Certificate\",\r\n"
				+ "    \"Professional Practice MSc / Postgrad Certificate\",\r\n"
				+ "    \"Public Health MPH\",\r\n"
				+ "    \"Speech and Language Therapy MSc\"\r\n"
				+ "  ],\r\n"
				+ "  \"Humanities\": [\r\n"
				+ "    \"Broadcast Journalism MA\",\r\n"
				+ "    \"Financial Journalism MA\",\r\n"
				+ "    \"Interactive Journalism MA\"\r\n"
				+ "  ],\r\n"
				+ "  \"Law\": [\r\n"
				+ "    \"International Business Law (distance learning) LLM\",\r\n"
				+ "    \"Civil Litigation and Dispute Resolution LLM\",\r\n"
				+ "    \"Criminal Litigation LLM\",\r\n"
				+ "    \"International Banking and Finance Law LLM\",\r\n"
				+ "    \"International Commercial Law LLM\",\r\n"
				+ "    \"International Human Rights LLM\",\r\n"
				+ "    \"Law (Graduate Entry) LLB\",\r\n"
				+ "    \"Legal Practice Course LLM/PGDip/PGCert\",\r\n"
				+ "    \"Legal Practice LLM\"\r\n"
				+ "  ],\r\n"
				+ "  \"Mathematics and Statistics\": [\r\n"
				+ "    \"Mathematics with Data Science MSci (Hons)\"\r\n"
				+ "  ],\r\n"
				+ "  \"Science and Technology\": [\r\n"
				+ "    \"Information Science MSc\",\r\n"
				+ "    \"Maritime Operations and Management in Greece MSc\",\r\n"
				+ "    \"Air Safety Management MSc\",\r\n"
				+ "    \"Air Transport Management MSc\",\r\n"
				+ "    \"Aircraft Maintenance Management MSc\",\r\n"
				+ "    \"Airport Management MSc\",\r\n"
				+ "    \"Civil Engineering Structures MSc\",\r\n"
				+ "    \"Construction Management MSc\"\r\n"
				+ "  ],\r\n"
				+ "  \"Social Sciences\": [\r\n"
				+ "    \"Research Methods MSc\",\r\n"
				+ "    \"Audiovisual Translation and Popular Culture MA\",\r\n"
				+ "    \"Clinical, Social and Cognitive Neuroscience MSc\",\r\n"
				+ "    \"Counselling Psychology (Graduate Certificate)\",\r\n"
				+ "    \"Creative Writing and Publishing MA\",\r\n"
				+ "    \"Creative Writing (Non-Fiction) MA\",\r\n"
				+ "    \"Creative Writing (Novels) MA\",\r\n"
				+ "    \"Creative Writing (Playwriting and Screenwriting) MA\",\r\n"
				+ "    \"Culture, Policy and Management MA\"\r\n"
				+ "  ]\r\n"
				+ "}";
		ObjectMapper mapper = new ObjectMapper();
	    mapper.enable(SerializationFeature.INDENT_OUTPUT);
	    @SuppressWarnings("unchecked")
	    Map <String, String[]> courses = mapper.readValue(jSon, new TypeReference<Map<String,String[]>>(){});
		String description= "The University of Leicester is in the East Midlands and currently has around 20,000 students enrolled, of which 1,500 of whom are international from over 80 different countries. The University of Leicester is one of the UK’s fastest growing universities and is currently undergoing a £300 million campus redevelopment programme. The University of Leicester was voted 'University of the Year' by the Times in 2008, and finished runner up in the same category in 2014"
				+ "	Leicester is well known for the strength of it its research, with its Archaeology department recently discovered the remains of Richard III, pushing it into the international spotlight. The Department of Physics and Astronomy hosts Europe’s largest university-based space research facility and the School of Museum Studies remains one of the top research departments in the country, containing the highest ranking research in Museum Studies in the UK.";
		String[] images = {"UniversityofLeicester.jpg","UniversityofLeicester1.jpg","UniversityofLeicester2.jpg","UniversityofLeicester3.jpg"};
		String reviews = "https://www.google.com/maps/place/University+of+Leicester/@52.6211425,-1.1272074,17z/data=!4m8!3m7!1s0x4877612fa55d947f:0xf8da17fed74e0044!8m2!3d52.6211393!4d-1.1246325!9m1!1b1!16zL20vMDF6bjR5?entry=ttu";
		String courseMap = "{\r\n"
				+ "  \"Anaesthesia and Peri-Operative Sciences PgDip\": \"https://www.lancaster.ac.uk/study/postgraduate/postgraduate-courses/anaesthesia-and-perioperative-sciences-pgdip/\",\r\n"
				+ "  \"Clinical Research MSc\": \"https://www.lancaster.ac.uk/study/postgraduate/postgraduate-courses/clinical-research-msc/\",\r\n"
				+ "  \"Medicine PhD\": \"https://www.lancaster.ac.uk/study/postgraduate/postgraduate-courses/medicine-phd/\",\r\n"
				+ "  \"Medicine M.D.\": \"https://www.lancaster.ac.uk/study/postgraduate/postgraduate-courses/medicine-md/\",\r\n"
				+ "  \"Biological Science PhD\": \"https://www.lancaster.ac.uk/study/postgraduate/postgraduate-courses/biological-science-phd/\",\r\n"
				+ "  \"Food Challenges for the 21st Century (Distance Learning) PgCert\": \"https://www.lancaster.ac.uk/study/postgraduate/postgraduate-courses/food-challenges-for-the-21st-century-distance-learning-pgcert/\",\r\n"
				+ "  \"Food Security (Distance Learning) MSc\": \"https://www.lancaster.ac.uk/study/postgraduate/postgraduate-courses/food-security-distance-learning-msc/\",\r\n"
				+ "  \"Food Security (Distance Learning) PgDip\": \"https://www.lancaster.ac.uk/study/postgraduate/postgraduate-courses/food-security-distance-learning-pgdip/\",\r\n"
				+ "  \"Plant Sciences MSc by Research\": \"https://www.lancaster.ac.uk/study/postgraduate/postgraduate-courses/plant-sciences-msc-by-research/\",\r\n"
				+ "  \"Electronic Engineering MSc\": \"https://www.lancaster.ac.uk/study/postgraduate/postgraduate-courses/electronic-engineering-msc/\",\r\n"
				+ "  \"Mechanical Engineering (Advanced) MSc\": \"https://www.lancaster.ac.uk/study/postgraduate/postgraduate-courses/mechanical-engineering-advanced-msc/\",\r\n"
				+ "  \"Mechanical Engineering with Project Management MSc\": \"https://www.lancaster.ac.uk/study/postgraduate/postgraduate-courses/mechanical-engineering-with-project-management-msc/\",\r\n"
				+ "  \"Natural Sciences MSc by Research\": \"https://www.lancaster.ac.uk/study/postgraduate/postgraduate-courses/natural-sciences-msc-by-research/\",\r\n"
				+ "  \"Art PhD\": \"https://www.lancaster.ac.uk/study/postgraduate/postgraduate-courses/art-phd/\",\r\n"
				+ "  \"Arts Management MA\": \"https://www.lancaster.ac.uk/study/postgraduate/postgraduate-courses/arts-management-ma/\",\r\n"
				+ "  \"Contemporary Arts PhD\": \"https://www.lancaster.ac.uk/study/postgraduate/postgraduate-courses/contemporary-arts-phd/\",\r\n"
				+ "  \"Fine Art MA\": \"https://www.lancaster.ac.uk/study/postgraduate/postgraduate-courses/fine-art-ma/\",\r\n"
				+ "  \"Architecture PhD\": \"https://www.lancaster.ac.uk/study/postgraduate/postgraduate-courses/architecture-phd/\",\r\n"
				+ "  \"Architecture (Master of) MArch\": \"https://www.lancaster.ac.uk/study/postgraduate/postgraduate-courses/architecture-master-of-march/\",\r\n"
				+ "  \"Accounting and Finance PhD\": \"https://www.lancaster.ac.uk/study/postgraduate/postgraduate-courses/accounting-and-finance-phd/\",\r\n"
				+ "  \"Accounting and Financial Management MSc\": \"https://www.lancaster.ac.uk/study/postgraduate/postgraduate-courses/accounting-and-financial-management-msc/\",\r\n"
				+ "  \"Finance MSc\": \"https://www.lancaster.ac.uk/study/postgraduate/postgraduate-courses/finance-msc/\",\r\n"
				+ "  \"Financial Analysis (Advanced) MSc\": \"https://www.lancaster.ac.uk/study/postgraduate/postgraduate-courses/financial-analysis-advanced-msc/\"\r\n"
				+ "}";
		UniversityDetails undetails = new UniversityDetails(3, "University of Leicester", "University Road, Leicester, LE1 7RH UK", courses, 4, description, images, "Telephone:  +44 (0)116 252 2522.", reviews,courseMap);
				
		this.universityRepo.save(undetails);
	
	return this.universityRepo.findAllByOrderByRatingDesc();
	}
	public List<UniversityDetails> getUniversitiesByName(String universityName, String courseName, String department) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<UniversityDetails> query = cb.createQuery(UniversityDetails.class);
        Root<UniversityDetails> university = query.from(UniversityDetails.class);
        
        MapJoin<UniversityDetails, String, String[]> courseJoin = university.join(UniversityDetails_.courses, JoinType.INNER);
        Path<String> departmentPath= courseJoin.key();
        Expression<String> coursePath= courseJoin.value().as(String.class);
        List<Predicate> predicates = new ArrayList<>();
        if(!universityName.equalsIgnoreCase("undefined")) {
        	Path<String> uName = university.get("universityName");
        	predicates.add(cb.like(uName, "%"+universityName+"%"));
        }
        if(!courseName.equalsIgnoreCase("undefined")) {
        	predicates.add(cb.like(coursePath, "%"+courseName+"%"));
        }
        if (!department.equalsIgnoreCase("undefined")) {
        	predicates.add(cb.like(departmentPath, "%"+department+"%"));
        }
        query.select(university).where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
        query.orderBy(cb.desc(university.get("rating")));

        return entityManager.createQuery(query).getResultList();
	}
	
	public Optional<UniversityDetails> getUniversityById(String unId) {
		return this.universityRepo.findById(Long.parseLong(unId));
		
	}

	
}
