package testData;

import util.PropertyFileWriter;
import util.UtilityClass;

import java.util.HashMap;

public class AssociateContactData extends BaseData
{
    public HashMap<String, String>[]  createNewContactData= new HashMap[2];;

    public HashMap<String, String>[]  createNewContactNegativeTestData= new HashMap[5];;
    public HashMap<String, String>[]  createNewContactValidationMessages =new HashMap[5];;
    public void generateArrayOfHashMaps(HashMap<String,String>[] dataSet)
    {

        for (int i = 0; i < dataSet.length; i++)
        {
            dataSet[i] = new HashMap<String,String>();

        }
    }
    public HashMap<String, String>[] generateDataForCreateNewContact()
    {
        generateArrayOfHashMaps(createNewContactData);
        createNewContactData[0].put("Company Type", "New Company");
        createNewContactData[0].put("Contact Name", "Roger");
        createNewContactData[0].put("Contact Email", UtilityClass.emailGenerator());
        createNewContactData[0].put("Contact Telephone", "67824755");
        createNewContactData[0].put("Contact Mobile", "556244356");
        createNewContactData[0].put("Contact Designation", "Design Architect");
        createNewContactData[0].put("Contact Lead Source", "Newsletter");
        createNewContactData[0].put("Contact Tags", "Designer");
        createNewContactData[0].put("Company", UtilityClass.companyNameGenerator());
        createNewContactData[0].put("Company Industry Type", "Designer");
        createNewContactData[0].put("Company City", "Vanceburg");
        createNewContactData[0].put("Company Website", "https://www.company.com");
        createNewContactData[0].put("Company Tags", "Architects");
        createNewContactData[0].put("Company Telephone", "88889977");
        createNewContactData[0].put("Company Fax", "0806752424");
        createNewContactData[0].put("Company Email", "Company" + UtilityClass.emailGenerator());
        createNewContactData[0].put("Company Address", "4586 North Bend River Road");
        createNewContactData[0].put("Company State", "Kentucky");
        createNewContactData[0].put("Company Zip", "41179");
        createNewContactData[0].put("Company Country", "Egypt");
        createNewContactData[0].put("Company Role", "Contractor");

        createNewContactData[1].put("Company Type", "Existing");
        createNewContactData[1].put("Contact Name", "Parth");
        createNewContactData[1].put("Contact Email", UtilityClass.emailGenerator());
        createNewContactData[1].put("Company", PropertyFileWriter.readFile("config.properties","Company_Name"));
        createNewContactData[1].put("Contact Telephone", "67824755");
        createNewContactData[1].put("Contact Mobile", "556244356");
        createNewContactData[1].put("Contact Lead Source", "Newsletter");
        createNewContactData[1].put("Contact Tags", "Glass House");
        createNewContactData[1].put("Company Role", "Contractor");

        return createNewContactData;
    }

    public HashMap<String, String>[] generateDataForCreateNewContactNegativeTesting()
    {
        generateArrayOfHashMaps(createNewContactNegativeTestData);
           createNewContactNegativeTestData[2].put("Company Type", "New Company");
           createNewContactNegativeTestData[2].put("Contact Name", "");
           createNewContactNegativeTestData[2].put("Contact Email", "");
           createNewContactNegativeTestData[2].put("Contact Telephone", "67824755");
           createNewContactNegativeTestData[2].put("Contact Mobile", "556244356");
           createNewContactNegativeTestData[2].put("Contact Designation", "Design Architect");
           createNewContactNegativeTestData[2].put("Contact Lead Source", "Newsletter");
           createNewContactNegativeTestData[2].put("Contact Tags", "Designer");
           createNewContactNegativeTestData[2].put("Company", "");
           createNewContactNegativeTestData[2].put("Company Industry Type", "Designer");
           createNewContactNegativeTestData[2].put("Company City", "Vanceburg");
           createNewContactNegativeTestData[2].put("Company Website", "https://www.company.com");
           createNewContactNegativeTestData[2].put("Company Tags", "Architects");
           createNewContactNegativeTestData[2].put("Company Address", "4586 North Bend River Road");
           createNewContactNegativeTestData[2].put("Company State", "Kentucky");
           createNewContactNegativeTestData[2].put("Company Zip", "41179");
           createNewContactNegativeTestData[2].put("Company Country", "Egypt");
           createNewContactNegativeTestData[2].put("Company Role", "Contractor");

          createNewContactNegativeTestData[1].put("Company Type", "New Company");
          createNewContactNegativeTestData[1].put("Contact Name", "1");
          createNewContactNegativeTestData[1].put("Contact Email", "nn!@#.@mail.com");
          createNewContactNegativeTestData[1].put("Contact Telephone", "67824755");
          createNewContactNegativeTestData[1].put("Contact Mobile", "556244356");
          createNewContactNegativeTestData[1].put("Contact Designation", "Design Architect");
          createNewContactNegativeTestData[1].put("Contact Lead Source", "Newsletter");
          createNewContactNegativeTestData[1].put("Contact Tags", "Designer");
          createNewContactNegativeTestData[1].put("Company", "9");
          createNewContactNegativeTestData[1].put("Company Industry Type", "Designer");
          createNewContactNegativeTestData[1].put("Company City", "Vanceburg");
          createNewContactNegativeTestData[1].put("Company Website", "https://www.company.com");
          createNewContactNegativeTestData[1].put("Company Tags", "Architects");
          createNewContactNegativeTestData[1].put("Company Address", "4586 North Bend River Road");
          createNewContactNegativeTestData[1].put("Company State", "Kentucky");
          createNewContactNegativeTestData[1].put("Company Zip", "41179");
          createNewContactNegativeTestData[1].put("Company Country", "Egypt");
          createNewContactNegativeTestData[1].put("Company Role", "Contractor");

           createNewContactNegativeTestData[0].put("Company Type", "Existing");
           createNewContactNegativeTestData[0].put("Contact Name", "Arjun Mathur");
           createNewContactNegativeTestData[0].put("Contact Email", UtilityClass.emailGenerator());
           createNewContactNegativeTestData[0].put("Company", PropertyFileWriter.readFile("config.properties","Company_Name"));
           createNewContactNegativeTestData[0].put("Contact Telephone", "67824755");
           createNewContactNegativeTestData[0].put("Contact Mobile", "556244356");
           createNewContactNegativeTestData[0].put("Contact Lead Source", "Newsletter");
           createNewContactNegativeTestData[0].put("Contact Tags", "Glass House");
           createNewContactNegativeTestData[0].put("Company Role", "");

          createNewContactNegativeTestData[3].put("Company Type", "New Company");
          createNewContactNegativeTestData[3].put("Contact Name", "Roger");
          createNewContactNegativeTestData[3].put("Contact Email", UtilityClass.emailGenerator());
          createNewContactNegativeTestData[3].put("Contact Telephone", "67824755");
          createNewContactNegativeTestData[3].put("Contact Mobile", "556244356");
          createNewContactNegativeTestData[3].put("Contact Designation", "Design Architect");
          createNewContactNegativeTestData[3].put("Contact Lead Source", "Newsletter");
          createNewContactNegativeTestData[3].put("Contact Tags", "Designer");
          createNewContactNegativeTestData[3].put("Company", UtilityClass.companyNameGenerator());
          createNewContactNegativeTestData[3].put("Company Industry Type", "");
          createNewContactNegativeTestData[3].put("Company City", "@#$$%Vanceburg");
          createNewContactNegativeTestData[3].put("Company Website", "https://test-designer.lovethat.design/opportunities/3193-a");
          createNewContactNegativeTestData[3].put("Company Tags", "Architects");
          createNewContactNegativeTestData[3].put("Company Address", "#%$^^% 4586 North Bend River Road");
          createNewContactNegativeTestData[3].put("Company State", "Kentucky");
          createNewContactNegativeTestData[3].put("Company Zip", "##$$41179");
          createNewContactNegativeTestData[3].put("Company Country", "");
          createNewContactNegativeTestData[3].put("Company Role", "Contractor");

          createNewContactNegativeTestData[4].put("Company Type", "New Company");
          createNewContactNegativeTestData[4].put("Contact Name", "Roger");
          createNewContactNegativeTestData[4].put("Contact Email", UtilityClass.emailGenerator());
          createNewContactNegativeTestData[4].put("Contact Telephone", "67824755");
          createNewContactNegativeTestData[4].put("Contact Mobile", "556244356");
          createNewContactNegativeTestData[4].put("Contact Designation", "Design Architect");
          createNewContactNegativeTestData[4].put("Contact Lead Source", "Newsletter");
          createNewContactNegativeTestData[4].put("Contact Tags", "Designer");
          createNewContactNegativeTestData[4].put("Company", UtilityClass.companyNameGenerator());
          createNewContactNegativeTestData[4].put("Company Industry Type", "Designer");
          createNewContactNegativeTestData[4].put("Company City", "Vanceburg");
          createNewContactNegativeTestData[4].put("Company Website", "https://www.company.com");
          createNewContactNegativeTestData[4].put("Company Tags", "Architects");
          createNewContactNegativeTestData[4].put("Company Telephone", "88889977");
          createNewContactNegativeTestData[4].put("Company Fax", "0806752424");
          createNewContactNegativeTestData[4].put("Company Email", "Company" + UtilityClass.emailGenerator());
          createNewContactNegativeTestData[4].put("Company Address", "4586 North Bend River Road");
          createNewContactNegativeTestData[4].put("Company State", "Kentucky");
          createNewContactNegativeTestData[4].put("Company Zip", "41179");
          createNewContactNegativeTestData[4].put("Company Country", "Egypt");
          createNewContactNegativeTestData[4].put("Company Role", "");

        return   createNewContactNegativeTestData;
    }

    public HashMap<String, String>[] generateCreateNewContactValidationMessages()
    {
        generateArrayOfHashMaps(createNewContactValidationMessages);

        createNewContactValidationMessages[2].put("Contact Name","Contact Name is required");
        createNewContactValidationMessages[2].put("Contact Email","Email is required");
        createNewContactValidationMessages[2].put("Company","Company Name is required");

        createNewContactValidationMessages[1].put("Contact Name","Minimum 2 characters required");
        createNewContactValidationMessages[1].put("Contact Email","Enter a valid Email");
        createNewContactValidationMessages[1].put("Company","Minimum 2 characters required");

        createNewContactValidationMessages[0].put("Company Role","Role is required");

        createNewContactValidationMessages[3].put("Company Industry Type", "Industry Type is required");
        createNewContactValidationMessages[3].put("Company City", "Enter a valid City");
        createNewContactValidationMessages[3].put("Company Address", "Special characters are not allowed");
        createNewContactValidationMessages[3].put("Company Country", "Country is required");
        createNewContactValidationMessages[3].put("Company Zip","Enter a valid ZIP/Postal Code");

        createNewContactValidationMessages[4].put("Company Role","Role is required");
        
        return createNewContactValidationMessages;

    }
}