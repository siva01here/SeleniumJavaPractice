package week6.day2;

import org.testng.annotations.DataProvider;

public class TestDataprovider {
	
	@DataProvider(name="createLead")
	public String[][] createLeadData()
	{
		return new String[][] {{"Data1FName","Data1LName","Data1LocalFName","Data1LocalLName","Data1IT","Data1Desc","data1@gmail.com","Data1ImpNoteForContact"},
			{"Data2FName","Data2LName","Data2LocalFName","Data2LocalLName","Data2Acct","Data2Desc","data2@gmail.com","Data2ImpNoteForContact"}};
	}

}
