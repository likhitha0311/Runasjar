package testData;

import util.PropertyFileWriter;
import util.UtilityClass;

import java.util.HashMap;

public class OpportunityData extends BaseData {
    public HashMap<String, String>[] createOpportunityData = new HashMap[2];

    public HashMap<String, String>[] editOpportunityData = new HashMap[2];

    public HashMap<String, String>[]  addOpportunityValidationMessages= new HashMap[4];

    public HashMap<String, String>[]  addOpportunityNegativeTestData= new HashMap[4];

    public HashMap<String, String>[]  editOpportunityValidationMessages= new HashMap[6];

    public HashMap<String, String>[]  editOpportunityNegativeTestData= new HashMap[6];

    public HashMap<String, String>[] editOpportunityLocationData=new HashMap[2];

    public HashMap<String, String>[] editOpportunityLocationNegativeTestData=new HashMap[1];

    public HashMap<String, String>[]  editOpportunityLocationValidationMessages=new HashMap[1];


    public void generateArrayOfHashMaps(HashMap<String, String>[] dataSet) {
        for (int i = 0; i < dataSet.length; i++) {
            dataSet[i] = new HashMap<String, String>();

        }
    }

    public HashMap<String, String>[] generateDataForCreateOpportunity() {
        generateArrayOfHashMaps(createOpportunityData);
        createOpportunityData[0].put("Customer Type", "New Customer");
       createOpportunityData[0].put("Opportunity Name", UtilityClass.opportunityNameGenerator());
       createOpportunityData[0].put("Service Type", "Product Design");
       createOpportunityData[0].put("Project Type", "Healthcare");
       createOpportunityData[0].put("Opportunity Folder", "https://opportunitydrive.com");
       createOpportunityData[0].put("Opportunity Country", "Algeria");
        createOpportunityData[0].put("Opportunity Owner", "Stephen");
       createOpportunityData[0].put("Opportunity Estimated Amount", "20000");
       createOpportunityData[0].put("Opportunity Tax", "2");
       createOpportunityData[0].put("Opportunity Tags", "Designer");
       createOpportunityData[0].put("Customer", UtilityClass.companyNameGenerator());
       createOpportunityData[0].put("Customer Industry Type", "Designer");
       createOpportunityData[0].put("Customer City", "Vanceburg");
       createOpportunityData[0].put("Customer Website", "https://www.customer.com");
       createOpportunityData[0].put("Customer Tags", "Architects");
       createOpportunityData[0].put("Customer Telephone", "88889977");
       createOpportunityData[0].put("Customer Fax", "0806752424");
       createOpportunityData[0].put("Customer Email", "Customer" + UtilityClass.emailGenerator());
       createOpportunityData[0].put("Customer Address", "4586 North Bend River Road");
       createOpportunityData[0].put("Customer State", "Kentucky");
       createOpportunityData[0].put("Customer Zip", "41179");
       createOpportunityData[0].put("Customer Country", "Egypt");

        createOpportunityData[1].put("Customer Type", "Existing");
        createOpportunityData[1].put("Opportunity Name", UtilityClass.opportunityNameGenerator());
        createOpportunityData[1].put("Customer", PropertyFileWriter.readFile("config.properties","Company_Name"));
        createOpportunityData[1].put("Service Type", "Interior Design");
        createOpportunityData[1].put("Project Type", "Healthcare");
        createOpportunityData[1].put("Opportunity Owner", "Stephen");
        createOpportunityData[1].put("Opportunity Country", "Singapore");
        createOpportunityData[1].put("Opportunity Estimated Amount", "10000");
        createOpportunityData[1].put("Opportunity Tax", "3");
        createOpportunityData[1].put("Opportunity State", "St Marina Island");
        createOpportunityData[1].put("Opportunity Zip", "41979");
        createOpportunityData[1].put("Opportunity Tags", "Studio Design");

        return createOpportunityData;
    }

    public HashMap<String, String>[] generateDataForAddOpportunityNegativeTesting() {
        generateArrayOfHashMaps(addOpportunityNegativeTestData);
        addOpportunityNegativeTestData[0].put("Customer Type", "New Customer");
        addOpportunityNegativeTestData[0].put("Opportunity Name", "");
        addOpportunityNegativeTestData[0].put("Service Type", "Product Design");
        addOpportunityNegativeTestData[0].put("Project Type", "Healthcare");
        addOpportunityNegativeTestData[0].put("Opportunity Folder", "://opportunitydrive.com");
        addOpportunityNegativeTestData[0].put("Opportunity Country", "");
        addOpportunityNegativeTestData[0].put("Opportunity Owner","Mohamed");
        addOpportunityNegativeTestData[0].put("Opportunity Estimated Amount", "20000");
        addOpportunityNegativeTestData[0].put("Opportunity Tax", "2");
        addOpportunityNegativeTestData[0].put("Opportunity Tags", "Designer");
        addOpportunityNegativeTestData[0].put("Customer", "");
        addOpportunityNegativeTestData[0].put("Customer Industry Type", "Designer");
        addOpportunityNegativeTestData[0].put("Customer City", "Vanceburg");
        addOpportunityNegativeTestData[0].put("Customer Website", "https://www.customer.com");
        addOpportunityNegativeTestData[0].put("Customer Tags", "Architects");
        addOpportunityNegativeTestData[0].put("Customer Telephone", "88889977");
        addOpportunityNegativeTestData[0].put("Customer Fax", "0806752424");
        addOpportunityNegativeTestData[0].put("Customer Email", "Customer" + UtilityClass.emailGenerator());
        addOpportunityNegativeTestData[0].put("Customer Address", "4586 North Bend River Road");
        addOpportunityNegativeTestData[0].put("Customer State", "Kentucky");
        addOpportunityNegativeTestData[0].put("Customer Zip", "41179");
        addOpportunityNegativeTestData[0].put("Customer Country", "Egypt");

        addOpportunityNegativeTestData[1].put("Customer Type", "New Customer");
        addOpportunityNegativeTestData[1].put("Opportunity Name", UtilityClass.opportunityNameGenerator());
        addOpportunityNegativeTestData[1].put("Opportunity Owner","Stephen");
        addOpportunityNegativeTestData[1].put("Service Type", "Product Design");
        addOpportunityNegativeTestData[1].put("Project Type", "Healthcare");
        addOpportunityNegativeTestData[1].put("Opportunity Folder", "https://opportunitydrive.com");
        addOpportunityNegativeTestData[1].put("Opportunity Country", "Algeria");
        addOpportunityNegativeTestData[1].put("Opportunity Estimated Amount", "20000");
        addOpportunityNegativeTestData[1].put("Opportunity Tax", "2");
        addOpportunityNegativeTestData[1].put("Opportunity Tags", "Designer");
        addOpportunityNegativeTestData[1].put("Customer", UtilityClass.companyNameGenerator());
        addOpportunityNegativeTestData[1].put("Customer Industry Type", "");
        addOpportunityNegativeTestData[1].put("Customer City", "@#$%");
        addOpportunityNegativeTestData[1].put("Customer Website", "https://www.");
        addOpportunityNegativeTestData[1].put("Customer Tags", "Architects");
        addOpportunityNegativeTestData[1].put("Customer Telephone", "88889977");
        addOpportunityNegativeTestData[1].put("Customer Fax", "0806752424");
        addOpportunityNegativeTestData[1].put("Customer Email", "Customer");
        addOpportunityNegativeTestData[1].put("Customer Address", "!@#$4586 North Bend River Road");
        addOpportunityNegativeTestData[1].put("Customer State", "Kentucky");
        addOpportunityNegativeTestData[1].put("Customer Zip", "41179");
        addOpportunityNegativeTestData[1].put("Customer Country", "");

       addOpportunityNegativeTestData[2].put("Customer Type", "Existing");
       addOpportunityNegativeTestData[2].put("Opportunity Owner","Mohamed");
       addOpportunityNegativeTestData[2].put("Opportunity Name", UtilityClass.opportunityNameGenerator());
       addOpportunityNegativeTestData[2].put("Customer", PropertyFileWriter.readFile("config.properties","Company_Name"));
       addOpportunityNegativeTestData[2].put("Service Type", "Interior Design");
       addOpportunityNegativeTestData[2].put("Project Type", "Healthcare");
       addOpportunityNegativeTestData[2].put("Opportunity Country", "");
       addOpportunityNegativeTestData[2].put("Opportunity Estimated Amount", "10000");
       addOpportunityNegativeTestData[2].put("Opportunity Tax", "3");
       addOpportunityNegativeTestData[2].put("Opportunity State", "St Marina Island");
       addOpportunityNegativeTestData[2].put("Opportunity Zip", "41979");
       addOpportunityNegativeTestData[2].put("Opportunity Tags", "Studio Design");

        addOpportunityNegativeTestData[3].put("Customer Type", "New Customer");
        addOpportunityNegativeTestData[3].put("Opportunity Name", "1");
        addOpportunityNegativeTestData[3].put("Opportunity Owner","Mohamed");
        addOpportunityNegativeTestData[3].put("Service Type", "Product Design");
        addOpportunityNegativeTestData[3].put("Project Type", "Healthcare");
        addOpportunityNegativeTestData[3].put("Opportunity Folder", "://opportunitydrive.com");
        addOpportunityNegativeTestData[3].put("Opportunity Country", "");
        addOpportunityNegativeTestData[3].put("Opportunity Estimated Amount", "20000");
        addOpportunityNegativeTestData[3].put("Opportunity Tax", "2");
        addOpportunityNegativeTestData[3].put("Opportunity Tags", "Designer");
        addOpportunityNegativeTestData[3].put("Customer", "");
        addOpportunityNegativeTestData[3].put("Customer Industry Type", "Designer");
        addOpportunityNegativeTestData[3].put("Customer City", "Vanceburg");
        addOpportunityNegativeTestData[3].put("Customer Website", "https://www.customer.com");
        addOpportunityNegativeTestData[3].put("Customer Tags", "Architects");
        addOpportunityNegativeTestData[3].put("Customer Telephone", "88889977");
        addOpportunityNegativeTestData[3].put("Customer Fax", "0806752424");
        addOpportunityNegativeTestData[3].put("Customer Email", "Customer" + UtilityClass.emailGenerator());
        addOpportunityNegativeTestData[3].put("Customer Address", "4586 North Bend River Road");
        addOpportunityNegativeTestData[3].put("Customer State", "Kentucky");
        addOpportunityNegativeTestData[3].put("Customer Zip", "41179");
        addOpportunityNegativeTestData[3].put("Customer Country", "Egypt");

        return addOpportunityNegativeTestData;
    }

    public HashMap<String, String>[] generateAddOpportunityValidationMessages()
    {
        generateArrayOfHashMaps(addOpportunityValidationMessages);

        addOpportunityValidationMessages[0].put("Opportunity Name","Opportunity Name is required");
        addOpportunityValidationMessages[0].put("Opportunity Country","Country is required");
        addOpportunityValidationMessages[0].put("Opportunity Folder","Enter a valid URL");
        addOpportunityValidationMessages[0].put("Customer","Customer is required");

        addOpportunityValidationMessages[1].put("Customer Industry Type", "Industry Type is required");
        addOpportunityValidationMessages[1].put("Customer City", "Enter a valid City");
        addOpportunityValidationMessages[1].put("Customer Email","Enter a valid Email");
        addOpportunityValidationMessages[1].put("Customer Address", "Special characters are not allowed");
        addOpportunityValidationMessages[1].put("Customer Country", "Country is required");

        addOpportunityValidationMessages[2].put("Opportunity Country","Country is required");

        addOpportunityValidationMessages[3].put("Opportunity Name","Minimum 2 characters required");
        addOpportunityValidationMessages[3].put("Opportunity Country","Country is required");
        addOpportunityValidationMessages[3].put("Opportunity Folder","Enter a valid URL");
        addOpportunityValidationMessages[3].put("Customer","Minimum 2 characters required");


        return addOpportunityValidationMessages;

    }


    public HashMap<String, String>[] generateDataForEditOpportunity()
    {
        generateArrayOfHashMaps( editOpportunityData);
       editOpportunityData[1].put("Customer Type", "New Customer");
       editOpportunityData[1].put("Opportunity Name", UtilityClass.opportunityNameGenerator());
       editOpportunityData[1].put("Service Type", "Architectural Design");
        editOpportunityData[1].put("Project Type", "Education");
       editOpportunityData[1].put("Opportunity Folder", "https://editedoppurtunitydrive.com");

       editOpportunityData[1].put("Opportunity Estimated Amount", "25000");
       editOpportunityData[1].put("Opportunity Tax", "21");
       editOpportunityData[1].put("Opportunity Tags", "Light house");
       editOpportunityData[1].put("Customer", UtilityClass.companyNameGenerator());
       editOpportunityData[1].put("Customer Industry Type", "Developer");
       editOpportunityData[1].put("Customer City", "Pretoria");
       editOpportunityData[1].put("Customer Website", "https://www.customer.com");
       editOpportunityData[1].put("Customer Tags", "Architects");
       editOpportunityData[1].put("Customer Telephone", "88889977");
       editOpportunityData[1].put("Customer Fax", "0806752424");
       editOpportunityData[1].put("Customer Email", "Customer" + UtilityClass.emailGenerator());
       editOpportunityData[1].put("Customer Address", "1960 Schoeman St");
       editOpportunityData[1].put("Customer State", "Gauteng");
       editOpportunityData[1].put("Customer Zip", "0073");
       editOpportunityData[1].put("Customer Country", "South Africa");

        editOpportunityData[0].put("Customer Type", "Existing");
        editOpportunityData[0].put("Opportunity Name", UtilityClass.opportunityNameGenerator());
        editOpportunityData[0].put("Customer", PropertyFileWriter.readFile("config.properties","Company_Name"));
        editOpportunityData[0].put("Service Type", "Interior Design");
        editOpportunityData[0].put("Project Type", "Education");
        editOpportunityData[0].put("Opportunity Country", "Botswana");
        editOpportunityData[0].put("Opportunity Estimated Amount", "5000");
        editOpportunityData[0].put("Opportunity Tax", "13");
        editOpportunityData[0].put("Opportunity State", " Gaborone");
        editOpportunityData[0].put("Opportunity Zip", "880");
        editOpportunityData[0].put("Opportunity Tags", "Love that Design");
        editOpportunityData[0].put("Opportunity City","Gaborone");

        return editOpportunityData;
    }

    public HashMap<String, String>[] generateDataForEditOpportunityNegativeTesting()
    {
        generateArrayOfHashMaps(editOpportunityNegativeTestData);
        
        
        editOpportunityNegativeTestData[0].put("Customer Type", "New Customer");
        editOpportunityNegativeTestData[0].put("Opportunity Name", UtilityClass.opportunityNameGenerator());
        editOpportunityNegativeTestData[0].put("Service Type", "Architectural Design");
        editOpportunityNegativeTestData[0].put("Project Type", "Education");
        editOpportunityNegativeTestData[0].put("Opportunity Folder", "https://editedoppurtunitydrive.com");
        editOpportunityNegativeTestData[0].put("Opportunity Owner", "Stephen");
        editOpportunityNegativeTestData[0].put("Opportunity Country", "Canada");
        editOpportunityNegativeTestData[0].put("Opportunity State", "Alberta");
        editOpportunityNegativeTestData[0].put("Opportunity Zip", "T0H 2G0");
        editOpportunityNegativeTestData[0].put("Opportunity City", "Keg River");
        editOpportunityNegativeTestData[0].put("Opportunity Estimated Amount", "25000");
        editOpportunityNegativeTestData[0].put("Opportunity Tax", "21");
        editOpportunityNegativeTestData[0].put("Opportunity Tags", "Light house");
        editOpportunityNegativeTestData[0].put("Customer", UtilityClass.companyNameGenerator());
        editOpportunityNegativeTestData[0].put("Customer Industry Type", "");
        editOpportunityNegativeTestData[0].put("Customer City", "*(&Pretoria");
        editOpportunityNegativeTestData[0].put("Customer Website", "https://");
        editOpportunityNegativeTestData[0].put("Customer Tags", "Architects");
        editOpportunityNegativeTestData[0].put("Customer Telephone", "88889977");
        editOpportunityNegativeTestData[0].put("Customer Fax", "0806752424");
        editOpportunityNegativeTestData[0].put("Customer Email", "Customer@##$$" + UtilityClass.emailGenerator());
        editOpportunityNegativeTestData[0].put("Customer Address", " #%%^ 1960 Schoeman St");
        editOpportunityNegativeTestData[0].put("Customer State", "Gauteng");
        editOpportunityNegativeTestData[0].put("Customer Zip", "0073");
        editOpportunityNegativeTestData[0].put("Customer Country", "");

        editOpportunityNegativeTestData[1].put("Customer Type", "Existing");
        editOpportunityNegativeTestData[1].put("Opportunity Name", "");
        editOpportunityNegativeTestData[1].put("Customer", "");
        editOpportunityNegativeTestData[1].put("Service Type", "Interior Design");
        editOpportunityNegativeTestData[1].put("Project Type", "Education");
        editOpportunityNegativeTestData[1].put("Opportunity Owner", "Stephen");
        editOpportunityNegativeTestData[1].put("Opportunity Country", "Botswana");
        editOpportunityNegativeTestData[1].put("Opportunity Estimated Amount", "5000");
        editOpportunityNegativeTestData[1].put("Opportunity Tax", "13");
        editOpportunityNegativeTestData[1].put("Opportunity State", " Gaborone");
        editOpportunityNegativeTestData[1].put("Opportunity Zip", "880");
        editOpportunityNegativeTestData[1].put("Opportunity Tags", "Love that Design");
        editOpportunityNegativeTestData[1].put("Opportunity City","Gaborone");

        return editOpportunityNegativeTestData;
    }

    public HashMap<String, String>[] generateEditOpportunityValidationMessages()
    {
        generateArrayOfHashMaps(editOpportunityValidationMessages);

        editOpportunityValidationMessages[0].put("Customer Industry Type", "Industry Type is required");
        editOpportunityValidationMessages[0].put("Customer City", "Enter a valid City");
        editOpportunityValidationMessages[0].put("Customer Email","Enter a valid Email");
        editOpportunityValidationMessages[0].put("Customer Address", "Special characters are not allowed");
        editOpportunityValidationMessages[0].put("Customer Country", "Country is required");

        editOpportunityValidationMessages[1].put("Opportunity Name","Opportunity Name is required");
        editOpportunityValidationMessages[1].put("Customer","Customer is required");


        return editOpportunityValidationMessages;

    }

    public HashMap<String, String>[]generateDataForUpdateOpportunityLocation()
    {

        generateArrayOfHashMaps(editOpportunityLocationData);

        editOpportunityLocationData[0].put("Opportunity State", "Melbourne");
        editOpportunityLocationData[0].put("Opportunity Zip", "880222");
        editOpportunityLocationData[0].put("Opportunity City", "Melbourne City");
        editOpportunityLocationData[0].put("Opportunity Country", "Australia");
        editOpportunityLocationData[0].put("Opportunity Address", "Queens Tower, Lane 32346");
        
        editOpportunityLocationData[1].put("Opportunity Country", "Canada");
        editOpportunityLocationData[1].put("Opportunity State", "Alberta");
        editOpportunityLocationData[1].put("Opportunity Zip", "T0H 2G0");
        editOpportunityLocationData[1].put("Opportunity City", "Keg River");

       return editOpportunityLocationData;
    }

    public HashMap<String, String>[] generateDataForEditOpportunityLocationNegativeTesting()
    {
        generateArrayOfHashMaps(editOpportunityLocationNegativeTestData);

        editOpportunityLocationNegativeTestData[0].put("Opportunity State", "Uganda State");
        editOpportunityLocationNegativeTestData[0].put("Opportunity Zip", "$$%^878786");
        editOpportunityLocationNegativeTestData[0].put("Opportunity City", "$$%^Melbourne City");
        editOpportunityLocationNegativeTestData[0].put("Opportunity Country", "Uganda");
        editOpportunityLocationNegativeTestData[0].put("Opportunity Address", "%^%&^&Queens Tower, Lane 32346");
        return editOpportunityLocationNegativeTestData;
    }

    public HashMap<String, String>[] generateEditOpportunityLocationValidationMessages()
    {
        generateArrayOfHashMaps(editOpportunityLocationValidationMessages);

        editOpportunityLocationValidationMessages[0].put("Opportunity City", "Enter a valid City");
        editOpportunityLocationValidationMessages[0].put("Opportunity Address", "Special characters are not allowed");
        editOpportunityLocationValidationMessages[0].put("Opportunity Zip","Enter a valid ZIP/Postal Code");

        return editOpportunityLocationValidationMessages;

    }
}