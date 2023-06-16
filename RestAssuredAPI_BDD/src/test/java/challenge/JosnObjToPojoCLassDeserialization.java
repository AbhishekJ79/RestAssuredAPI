package challenge;

import challenge.StudentDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static io.restassured.RestAssured.given;

public class JosnObjToPojoCLassDeserialization {

	// json object to data -deserialization
	public static void main(String[] args) throws JsonProcessingException {
		String jsonBody="{\n" +
				"  \"name\": \"Peter Smith\",\n" +
				"  \"marks\": [\n" +
				"    {\n" +
				"      \"subject\": \"Maths\",\n" +
				"      \"mark\": 60\n" +
				"    },\n" +
				"    {\n" +
				"      \"subject\": \"Science\",\n" +
				"      \"mark\": 50\n" +
				"    },\n" +
				"    {\n" +
				"      \"subject\": \"english\",\n" +
				"      \"mark\": 40\n" +
				"    },\n" +
				"    {\n" +
				"      \"subject\": \"history\",\n" +
				"      \"mark\": 50\n" +
				"    }\n" +
				"  ],\n" +
				"  \"studentAverage\": null,\n" +
				"  \"studentPass\": null\n" +
				"}";

///////////////desrialization/////////////////////

		ObjectMapper objMapper = new ObjectMapper();
		//desrialization
		StudentDetails emp=objMapper.readValue(jsonBody, StudentDetails.class);
		String StudentName=emp.getName();

		List<Mark> Studentmark=emp.getMarks();

		int Mathsmarks=Studentmark.get(0).getMark();
		String MathSub=Studentmark.get(0).getSubject();
		int Sciencemarks2=Studentmark.get(1).getMark();
		String ScienceSub=Studentmark.get(1).getSubject();
		int englishmarks3=Studentmark.get(2).getMark();
		String EngSub=Studentmark.get(2).getSubject();
		int historymarks4=Studentmark.get(3).getMark();
		String historySub=Studentmark.get(3).getSubject();

		int totalSubject=Studentmark.size();
		int avg=(Mathsmarks+Sciencemarks2+englishmarks3+historymarks4)/totalSubject;

		double studentAvg= emp.getStudentAverage();
		studentAvg=avg;

		boolean studentStatus=emp.getStudentPass();

		if(studentAvg>=50)
		{
			studentStatus=true;
		}
		else studentStatus=false;

/////////// Serialization///////////////////////////////

		StudentDetails obj = new StudentDetails();

		obj.setName(StudentName);

		Mark mathObj= new Mark();
		mathObj.setMark(Mathsmarks);
		mathObj.setSubject(MathSub);

		Mark ScienceObj= new Mark();
		ScienceObj.setMark(Sciencemarks2);
		ScienceObj.setSubject(ScienceSub);

		Mark englishObj= new Mark();
		englishObj.setMark(englishmarks3);
		englishObj.setSubject(EngSub);

		Mark historyObj= new Mark();
		historyObj.setMark(historymarks4);
		historyObj.setSubject(historySub);

		List<Mark> marks = new ArrayList<Mark>();
		marks.add(mathObj);
		marks.add(ScienceObj);
		marks.add(englishObj);
		marks.add(historyObj);

		obj.setMarks(marks);

      obj.setStudentAverage(studentAvg);
	  obj.setStudentPass(studentStatus);

		ObjectMapper objMapper1 = new ObjectMapper();
		String json=objMapper1.writerWithDefaultPrettyPrinter().writeValueAsString(obj); // convert into pretty json as string and pass as body
			System.out.println(json);

	}

}
