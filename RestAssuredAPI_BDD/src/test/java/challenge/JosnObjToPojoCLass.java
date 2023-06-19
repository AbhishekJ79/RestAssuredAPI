package challenge;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;


public class JosnObjToPojoCLass {

	// json object to data -deserialization
	public static void main(String[] args) throws JsonProcessingException {
		// also we can add the json string in file
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
		StudentDetails emp=objMapper.readValue(jsonBody, StudentDetails.class);

		String StudentName=emp.getName();

		List<Mark> StudentMark=emp.getMarks();

		int Mathsmarks=StudentMark.get(0).getMark();
		String MathSub=StudentMark.get(0).getSubject();
		int ScienceMarks=StudentMark.get(1).getMark();
		String ScienceSub=StudentMark.get(1).getSubject();
		int englishMarks=StudentMark.get(2).getMark();
		String EngSub=StudentMark.get(2).getSubject();
		int historyMarks=StudentMark.get(3).getMark();
		String historySub=StudentMark.get(3).getSubject();

		int totalSubject=StudentMark.size();
		int avg=(Mathsmarks+ScienceMarks+englishMarks+historyMarks)/totalSubject;

		double studentAvg= emp.getStudentAverage();
		studentAvg=avg;

		boolean studentStatus=emp.getStudentPass();

		if(studentAvg>=50)
			studentStatus=true;

		else
			studentStatus=false;

////////////////// Serialization///////////////////////////////

		StudentDetails obj = new StudentDetails();

		obj.setName(StudentName);

		Mark mathObj= new Mark();
		mathObj.setMark(Mathsmarks);
		mathObj.setSubject(MathSub);

		Mark ScienceObj= new Mark();
		ScienceObj.setMark(ScienceMarks);
		ScienceObj.setSubject(ScienceSub);

		Mark englishObj= new Mark();
		englishObj.setMark(englishMarks);
		englishObj.setSubject(EngSub);

		Mark historyObj= new Mark();
		historyObj.setMark(historyMarks);
		historyObj.setSubject(historySub);

		List<Mark> marks = new ArrayList<>();
		marks.add(mathObj);
		marks.add(ScienceObj);
		marks.add(englishObj);
		marks.add(historyObj);

		obj.setMarks(marks);

      obj.setStudentAverage(studentAvg);
	  obj.setStudentPass(studentStatus);

		ObjectMapper objMapper1 = new ObjectMapper();
		String response=objMapper1.writerWithDefaultPrettyPrinter().writeValueAsString(obj); // convert into pretty json as string and pass as body
		System.out.println(response);

	}

}
