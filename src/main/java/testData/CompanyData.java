package testData;

import util.UtilityClass;

import java.util.HashMap;

public class CompanyData extends BaseData {
    public HashMap<String, String>[] createCompanyData = new HashMap[2];

    public HashMap<String, String>[] editCompanyData = new HashMap[2];

    public HashMap<String, String>[] createContactInsideCompanyData= new HashMap[1];

    public HashMap<String, String>[]  editContactInsideCompanyData= new HashMap[1];

    public HashMap<String, String>[]  addCompanyValidationMessages= new HashMap[3];

    public HashMap<String, String>[]  addCompanyNegativeTestData= new HashMap[3];

    public HashMap<String, String>[]  editCompanyValidationMessages= new HashMap[4];

    public HashMap<String, String>[]  editCompanyNegativeTestData= new HashMap[4];


    public void generateArrayOfHashMaps(HashMap<String, String>[] dataSet) {
        for (int i = 0; i < dataSet.length; i++) {
            dataSet[i] = new HashMap<String, String>();
        }
    }

    public HashMap<String, String>[] generateDataForCreateContactInsideCompany()
    {
        generateArrayOfHashMaps(createContactInsideCompanyData);

        createContactInsideCompanyData[0].put("Contact Name", "Samay");
        createContactInsideCompanyData[0].put("Contact Email", UtilityClass.emailGenerator());
        createContactInsideCompanyData[0].put("Contact Lead Source", "Indeed");
        createContactInsideCompanyData[0].put("Contact Designation", "IT Dept head");
        createContactInsideCompanyData[0].put("Contact Telephone", "67824755");
        createContactInsideCompanyData[0].put("Contact Mobile", "556244356");
        createContactInsideCompanyData[0].put("Contact Tags", "Designer");
       
return createContactInsideCompanyData;
    }

    public HashMap<String, String>[] generateDataForEditContactInsideCompany()
    {
        generateArrayOfHashMaps( editContactInsideCompanyData);

        editContactInsideCompanyData[0].put("Contact Name", "Sanjay");
        editContactInsideCompanyData[0].put("Contact Email", UtilityClass.emailGenerator());
        editContactInsideCompanyData[0].put("Contact Lead Source", "Indeed Updated");
        editContactInsideCompanyData[0].put("Contact Designation", "Sales Head");
        editContactInsideCompanyData[0].put("Contact Telephone", "897867665");
        editContactInsideCompanyData[0].put("Contact Mobile", "67888897667");
        editContactInsideCompanyData[0].put("Contact Tags", "Engineer");

        return editContactInsideCompanyData;
    }


    public HashMap<String, String>[] generateDataForCreateCompany() 
    {
        generateArrayOfHashMaps(createCompanyData);

        createCompanyData[0].put("Company Name", UtilityClass.companyNameGenerator());
        createCompanyData[0].put("Company Industry Type", "Manufacturer");
        createCompanyData[0].put("Company State", "Sydney");
        createCompanyData[0].put("Company Country", "Australia");

        createCompanyData[1].put("Company Name", UtilityClass.companyNameGenerator());
        createCompanyData[1].put("Company Industry Type", "Designer");
        createCompanyData[1].put("Company City", "Vanceburg");
        createCompanyData[1].put("Company Website", "https://www.company.com");
        createCompanyData[1].put("Company Tags", "Architects");
        createCompanyData[1].put("Company Telephone", "88889977");
        createCompanyData[1].put("Company Fax", "0806752424");
        createCompanyData[1].put("Company Email", "Company" + UtilityClass.emailGenerator());
        createCompanyData[1].put("Company Address", "4586 North Bend River Road");
        createCompanyData[1].put("Company State", "Kentucky");
        createCompanyData[1].put("Company Zip", "41179");
        createCompanyData[1].put("Company Country", "Egypt");

        return createCompanyData;
    }

    public HashMap<String, String>[] generateDataForUpdateCompany()
    {
        generateArrayOfHashMaps(editCompanyData);
        editCompanyData[0].put("Company Name", UtilityClass.companyNameGenerator());
        editCompanyData[0].put("Company Industry Type", "Designer");
        editCompanyData[0].put("Company City", "Vanceburg");
        editCompanyData[0].put("Company Website", "https://www.company.com");
        editCompanyData[0].put("Company Tags", "Villa");
        editCompanyData[0].put("Company Telephone", "63450637");
        editCompanyData[0].put("Company Fax", "0809678");
        editCompanyData[0].put("Company Email", "Company" + UtilityClass.emailGenerator());
        editCompanyData[0].put("Company Address", "80 Marine Parade Road");
        editCompanyData[0].put("Company State", "Singapore");
        editCompanyData[0].put("Company Zip", "449269");
        editCompanyData[0].put("Company Country", "Singapore");

        editCompanyData[1].put("Company Name", UtilityClass.companyNameGenerator());
        editCompanyData[1].put("Company Industry Type", "Developer");
        editCompanyData[1].put("Company State", "Munich");
        editCompanyData[1].put("Company Country", "Germany");
        return editCompanyData;
    }

    public HashMap<String, String>[] generateDataForAddCompanyNegativeTesting()
    {
        generateArrayOfHashMaps(addCompanyNegativeTestData);
        addCompanyNegativeTestData[0].put("Company Name", "");
        addCompanyNegativeTestData[0].put("Company Industry Type", "");
        addCompanyNegativeTestData[0].put("Company Email", "bnbmbg");
        addCompanyNegativeTestData[0].put("Company City", "dfd45###");
        addCompanyNegativeTestData[0].put("Company Address", "80 Marine@#$% Parade Road");

        addCompanyNegativeTestData[1].put("Company Name", "28 lightbulbs");
        addCompanyNegativeTestData[1].put("Company Website", "abcd");

        addCompanyNegativeTestData[2].put("Company Name", "");
        addCompanyNegativeTestData[2].put("Company Industry Type", "");
        addCompanyNegativeTestData[2].put("Company Email", "company@mail.com");
        addCompanyNegativeTestData[2].put("Company City", "Venice");

        return  addCompanyNegativeTestData;

    }

    public HashMap<String, String>[] generateAddCompanyValidationMessages()
    {
        generateArrayOfHashMaps(addCompanyValidationMessages);
        addCompanyValidationMessages[0].put("Company Name", "Company Name is required");
        addCompanyValidationMessages[0].put("Company Industry Type", "Industry Type is required");
        addCompanyValidationMessages[0].put("Company Email", "Enter a valid Email");
        addCompanyValidationMessages[0].put("Company City", "Enter a valid City");
        addCompanyValidationMessages[0].put("Company Address", "Special characters are not allowed");

        addCompanyValidationMessages[1].put("Company Name", "Company Name already exists");

        addCompanyValidationMessages[2].put("Company Name", "Company Name is required");
        addCompanyValidationMessages[2].put("Company Industry Type", "Industry Type is required");


        return  addCompanyNegativeTestData;

    }

    public HashMap<String, String>[] generateDataForEditCompanyNegativeTesting()
    {
        generateArrayOfHashMaps(editCompanyNegativeTestData);
        editCompanyNegativeTestData[0].put("Company Name", "");
        editCompanyNegativeTestData[0].put("Company Industry Type", "");
        editCompanyNegativeTestData[0].put("Company Email", "bnbmbg");
        editCompanyNegativeTestData[0].put("Company City", "dfd45###");
        editCompanyNegativeTestData[0].put("Company Address", "80 Marine@#$% Parade Road");

        editCompanyNegativeTestData[1].put("Company Name", "28 lightbulbs");
        editCompanyNegativeTestData[1].put("Company Website", "abcd");

        editCompanyNegativeTestData[2].put("Company Name", "");
        editCompanyNegativeTestData[2].put("Company Industry Type", "");
        editCompanyNegativeTestData[2].put("Company Email", "company@mail.com");
        editCompanyNegativeTestData[2].put("Company City", "Venice");

        editCompanyNegativeTestData[3].put("Company Name", "6");
        editCompanyNegativeTestData[3].put("Company Industry Type", "");
        editCompanyNegativeTestData[3].put("Company Email", "company@mail.com");
        editCompanyNegativeTestData[3].put("Company City", "Venice");

        return  editCompanyNegativeTestData;

    }

    public HashMap<String, String>[] generateEditCompanyValidationMessages()
    {
        generateArrayOfHashMaps(editCompanyValidationMessages);
        editCompanyValidationMessages[0].put("Company Name", "Company Name is required");
        editCompanyValidationMessages[0].put("Company Industry Type", "Industry Type is required");
        editCompanyValidationMessages[0].put("Company Email", "Enter a valid Email");
        editCompanyValidationMessages[0].put("Company City", "Enter a valid City");
        editCompanyValidationMessages[0].put("Company Address", "Special characters are not allowed");

        editCompanyValidationMessages[1].put("Company Name", "Company Name already exists");

        editCompanyValidationMessages[2].put("Company Name", "Company Name is required");
        editCompanyValidationMessages[2].put("Company Industry Type", "Industry Type is required");

        editCompanyValidationMessages[3].put("Company Name", "Minimum 2 characters required");
        editCompanyValidationMessages[3].put("Company Industry Type", "Industry Type is required");


        return  editCompanyValidationMessages;

    }


}