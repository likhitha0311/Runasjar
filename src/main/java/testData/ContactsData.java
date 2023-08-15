package testData;

import util.PropertyFileWriter;
import util.UtilityClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ContactsData extends BaseData
{
    ExistingData ed=new ExistingData();
    public HashMap<String, String>[]  createContactData= new HashMap[4];;

    public HashMap<String, String>[] editContactData = new HashMap[3];

    public HashMap<String, String>[]  addContactValidationMessages= new HashMap[2];

    public HashMap<String, String>[]  addContactNegativeTestData= new HashMap[2];

    public HashMap<String, String>[]  editContactValidationMessages= new HashMap[6];

    public HashMap<String, String>[]  editContactNegativeTestData= new HashMap[6];

    public void generateArrayOfHashMaps(HashMap<String,String>[] dataSet)
     {

         for (int i = 0; i < dataSet.length; i++)
         {
             dataSet[i] = new HashMap<String,String>();

         }
    }

    public HashMap<String, String>[] generateDataForAddContactNegativeTesting() {
        generateArrayOfHashMaps(addContactNegativeTestData);

        addContactNegativeTestData[0].put("Company Type", "Without Company");
        addContactNegativeTestData[0].put("Contact Name", "");
        addContactNegativeTestData[0].put("Contact Email", "mmm.com");

        addContactNegativeTestData[1].put("Company Type", "New Company");
        addContactNegativeTestData[1].put("Contact Name", "Kevin");
        addContactNegativeTestData[1].put("Contact Email", UtilityClass.emailGenerator());
        addContactNegativeTestData[1].put("Company", UtilityClass.companyNameGenerator());
        addContactNegativeTestData[1].put("Contact Tags", "Designer");
        addContactNegativeTestData[1].put("Company Industry Type", "Designer");
        addContactNegativeTestData[1].put("Company City", "Venice");
        addContactNegativeTestData[1].put("Company Website", "https://www.company.com");
        addContactNegativeTestData[1].put("Company Tags", "Architects");
        addContactNegativeTestData[1].put("Company Telephone", "88889977");
        addContactNegativeTestData[1].put("Company Fax", "0806752424");
        addContactNegativeTestData[1].put("Company Email", "abcd@email.com");
        addContactNegativeTestData[1].put("Company Address", "4586 North Bend River Road");
        addContactNegativeTestData[1].put("Company State", "Kentucky");
        addContactNegativeTestData[1].put("Company Zip", "41179");
        addContactNegativeTestData[1].put("Company Country", "Egypt");

//
//
//        addContactNegativeTestData[2].put("Company Type", "Without Company");
//        addContactNegativeTestData[2].put("Contact Name", "");
//        addContactNegativeTestData[2].put("Contact Email", "3197@email.com");
//
//        addContactNegativeTestData[3].put("Company Type", "Existing");
//        addContactNegativeTestData[3].put("Contact Name", "Ajay");
//        addContactNegativeTestData[3].put("Contact Email", UtilityClass.emailGenerator());
//        addContactNegativeTestData[3].put("Company", "Tacobell");
//        addContactNegativeTestData[3].put("Contact LinkedinUrl", "kevin");
//
//        addContactNegativeTestData[4].put("Company Type", "New Company");
//        addContactNegativeTestData[4].put("Contact Name", "Kevin");
//        addContactNegativeTestData[4].put("Contact Email", UtilityClass.emailGenerator());
//        addContactNegativeTestData[4].put("Contact LinkedinUrl", "https://www.linkedin.com/kevin");
//        addContactNegativeTestData[4].put("Contact Telephone", "67824755");
//        addContactNegativeTestData[4].put("Contact Mobile", "556244356");
//        addContactNegativeTestData[4].put("Contact Contact Designation", "Design Architect");
//        addContactNegativeTestData[4].put("Contact Lead Source", "Newsletter");
//        addContactNegativeTestData[4].put("Contact Tags", "Designer");
//        addContactNegativeTestData[4].put("Company", UtilityClass.companyNameGenerator());
//        addContactNegativeTestData[4].put("Company Industry Type", "");
//        addContactNegativeTestData[4].put("Company City", "@#$!!");
//        addContactNegativeTestData[4].put("Company Website", "https://www.company.com");
//        addContactNegativeTestData[4].put("Company Tags", "Architects");
//        addContactNegativeTestData[4].put("Company Telephone", "88889977");
//        addContactNegativeTestData[4].put("Company Fax", "0806752424");
//        addContactNegativeTestData[4].put("Company Email", "Company" + UtilityClass.emailGenerator());
//        addContactNegativeTestData[4].put("Company Address", "4586 North Bend River Road #$^%$##");
//        addContactNegativeTestData[4].put("Company State", "Kentucky");
//        addContactNegativeTestData[4].put("Company Zip", "41179");
//        addContactNegativeTestData[4].put("Company Country", "");
//
//        addContactNegativeTestData[5].put("Company Type", "Without Company");
//        addContactNegativeTestData[5].put("Contact Name", "");
//        addContactNegativeTestData[5].put("Contact Email", "");


        return addContactNegativeTestData;

    }

    public HashMap<String, String>[] generateAddContactValidationMessages()
    {
        generateArrayOfHashMaps(addContactValidationMessages);

        addContactValidationMessages[0].put("Contact Name","Contact Name is required");
        addContactValidationMessages[0].put("Contact Email","Enter a valid Email");

        addContactValidationMessages[1].put("Company Email","Enter a valid Email");

        addContactValidationMessages[2].put("Contact Name","Contact Name is required");
        addContactValidationMessages[2].put("Contact Email","Email already exists");

        addContactValidationMessages[3].put("Contact LinkedinUrl", "Enter a valid LinkedIn URL");

        addContactValidationMessages[4].put("Company Industry Type", "Industry Type is required");
        addContactValidationMessages[4].put("Company City", "Enter a valid City");
        addContactValidationMessages[4].put("Company Address", "Special characters are not allowed");
        addContactValidationMessages[4].put("Company Country", "Country is required");

        addContactValidationMessages[5].put("Contact Name","Contact Name is required");
        addContactValidationMessages[5].put("Contact Email","Email is required");

        return addContactValidationMessages;

    }

    public HashMap<String, String>[] generateDataForEditContactNegativeTesting() {
        generateArrayOfHashMaps(editContactNegativeTestData);
        editContactNegativeTestData[0].put("Company Type", "Without Company");
        editContactNegativeTestData[0].put("Contact Name", "");
        editContactNegativeTestData[0].put("Contact Email", "mmm.com");

        editContactNegativeTestData[1].put("Company Type", "Without Company");
        editContactNegativeTestData[1].put("Contact Name", "");
        editContactNegativeTestData[1].put("Contact Email", "3197@email.com");
        
         editContactNegativeTestData[2].put("Company Type", "New Company");
         editContactNegativeTestData[2].put("Contact Name", "Kevin");
         editContactNegativeTestData[2].put("Contact Email", UtilityClass.emailGenerator());
         editContactNegativeTestData[2].put("Company", UtilityClass.companyNameGenerator());
         editContactNegativeTestData[2].put("Contact Tags", "Designer");
         editContactNegativeTestData[2].put("Company Industry Type", "Designer");
         editContactNegativeTestData[2].put("Company City", "Venice");
         editContactNegativeTestData[2].put("Company Website", "https://www.company.com");
         editContactNegativeTestData[2].put("Company Tags", "Architects");
         editContactNegativeTestData[2].put("Company Telephone", "88889977");
         editContactNegativeTestData[2].put("Company Fax", "0806752424");
         editContactNegativeTestData[2].put("Company Email", "abcd");
         editContactNegativeTestData[2].put("Company Address", "4586 North Bend River Road");
         editContactNegativeTestData[2].put("Company State", "Kentucky");
         editContactNegativeTestData[2].put("Company Zip", "41179");
         editContactNegativeTestData[2].put("Company Country", "Egypt");

         editContactNegativeTestData[3].put("Company Type", "Existing");
         editContactNegativeTestData[3].put("Contact Name", "Ajay");
         editContactNegativeTestData[3].put("Contact Email", UtilityClass.emailGenerator());
         editContactNegativeTestData[3].put("Company", "Tacobell");
         editContactNegativeTestData[3].put("Contact LinkedinUrl", "kevin");

         editContactNegativeTestData[4].put("Company Type", "New Company");
         editContactNegativeTestData[4].put("Contact Name", "Kevin");
         editContactNegativeTestData[4].put("Contact Email", UtilityClass.emailGenerator());
         editContactNegativeTestData[4].put("Contact LinkedinUrl", "https://www.linkedin.com/kevin");
         editContactNegativeTestData[4].put("Contact Telephone", "67824755");
         editContactNegativeTestData[4].put("Contact Mobile", "556244356");
         editContactNegativeTestData[4].put("Contact Designation", "Design Architect");
         editContactNegativeTestData[4].put("Contact Lead Source", "Newsletter");
         editContactNegativeTestData[4].put("Contact Tags", "Designer");
         editContactNegativeTestData[4].put("Company", UtilityClass.companyNameGenerator());
         editContactNegativeTestData[4].put("Company Industry Type", "");
         editContactNegativeTestData[4].put("Company City", "@#$!!");
         editContactNegativeTestData[4].put("Company Website", "https://www.company.com");
         editContactNegativeTestData[4].put("Company Tags", "Architects");
         editContactNegativeTestData[4].put("Company Telephone", "88889977");
         editContactNegativeTestData[4].put("Company Fax", "0806752424");
         editContactNegativeTestData[4].put("Company Email", "Company" + UtilityClass.emailGenerator());
         editContactNegativeTestData[4].put("Company Address", "4586 North Bend River Road #$^%$##");
         editContactNegativeTestData[4].put("Company State", "Kentucky");
         editContactNegativeTestData[4].put("Company Zip", "41179");
         editContactNegativeTestData[4].put("Company Country", "");

        

        editContactNegativeTestData[5].put("Company Type", "Without Company");
        editContactNegativeTestData[5].put("Contact Name", "1");
        editContactNegativeTestData[5].put("Contact Email", " ");


        return  editContactNegativeTestData;

    }

    public HashMap<String, String>[] generateEditContactValidationMessages()
    {
        generateArrayOfHashMaps(editContactValidationMessages);


        editContactValidationMessages[0].put("Contact Name","Contact Name is required");
        editContactValidationMessages[0].put("Contact Email","Enter a valid Email");

        editContactValidationMessages[1].put("Contact Name","Contact Name is required");
        editContactValidationMessages[1].put("Contact Email","Email already exists");

        editContactValidationMessages[2].put("Company Email","Enter a valid Email");

        editContactValidationMessages[3].put("Contact LinkedinUrl", "Enter a valid LinkedIn URL");

        editContactValidationMessages[4].put("Company Industry Type", "Industry Type is required");
        editContactValidationMessages[4].put("Company City", "Enter a valid City");
        editContactValidationMessages[4].put("Company Address", "Special characters are not allowed");
        editContactValidationMessages[4].put("Company Country", "Country is required");

        editContactValidationMessages[5].put("Contact Name","Minimum 2 characters required");
        editContactValidationMessages[5].put("Contact Email","Email is required");



        return editContactValidationMessages;

    }


    public HashMap<String, String>[] generateDataForCreateContact()
    {
        generateArrayOfHashMaps(createContactData);

       createContactData[0].put("Company Type", "New Company");
       createContactData[0].put("Contact Name", "Thompson");
       createContactData[0].put("Contact Email", UtilityClass.emailGenerator());
       createContactData[0].put("Contact Tags", "Designer");
       createContactData[0].put("Company", UtilityClass.companyNameGenerator());
       createContactData[0].put("Company Industry Type", "Designer");
       createContactData[0].put("Company City", "Vanceburg");
       createContactData[0].put("Company Website", "https://www.company.com");
       createContactData[0].put("Company Tags", "Architects");
       createContactData[0].put("Company Telephone", "88889977");
       createContactData[0].put("Company Fax", "0806752424");
       createContactData[0].put("Company Email", "Company" + UtilityClass.emailGenerator());
       createContactData[0].put("Company Address", "4586 North Bend River Road");
       createContactData[0].put("Company State", "Kentucky");
       createContactData[0].put("Company Zip", "41179");
       createContactData[0].put("Company Country", "Egypt");

        createContactData[3].put("Company Type", "Existing");
        createContactData[3].put("Contact Name", "Ajay");
        createContactData[3].put("Contact Email", UtilityClass.emailGenerator());
        createContactData[3].put("Company", PropertyFileWriter.readFile("config.properties","Company_Name"));
        createContactData[3].put("Contact Telephone", "67824755");
        createContactData[3].put("Contact Mobile", "556244356");
        createContactData[3].put("Contact Lead Source", "Newsletter");
        createContactData[3].put("Contact Tags", "Designer");
        createContactData[3].put("Company Tags", "Architects");


        createContactData[1].put("Company Type", "New Company");
        createContactData[1].put("Contact Name", "Kevin");
        createContactData[1].put("Contact Email", UtilityClass.emailGenerator());
        createContactData[1].put("Contact LinkedinUrl", "https://www.linkedin.com/kevin");
        createContactData[1].put("Contact Telephone", "67824755");
        createContactData[1].put("Contact Mobile", "556244356");
        createContactData[1].put("Contact Designation", "Design Architect");
        createContactData[1].put("Contact Lead Source", "Newsletter");
        createContactData[1].put("Contact Tags", "Designer");
        createContactData[1].put("Company", UtilityClass.companyNameGenerator());
        createContactData[1].put("Company Industry Type", "Designer");
        createContactData[1].put("Company City", "Vanceburg");
        createContactData[1].put("Company Website", "https://www.company.com");
        createContactData[1].put("Company Tags", "Architects");
        createContactData[1].put("Company Telephone", "88889977");
        createContactData[1].put("Company Fax", "0806752424");
        createContactData[1].put("Company Email", "Company" + UtilityClass.emailGenerator());
        createContactData[1].put("Company Address", "4586 North Bend River Road");
        createContactData[1].put("Company State", "Kentucky");
        createContactData[1].put("Company Zip", "41179");
        createContactData[1].put("Company Country", "Egypt");

        createContactData[2].put("Company Type", "Without Company");
        createContactData[2].put("Contact Name", "Thompson");
        createContactData[2].put("Contact Email", UtilityClass.emailGenerator());
        createContactData[2].put("Contact LinkedinUrl", "https://www.linkedin.com/thompson");
        createContactData[2].put("Contact Telephone", "67824755");
        createContactData[2].put("Contact Mobile", "556244356");
        createContactData[2].put("Contact Designation", "Marketing Head");
        createContactData[2].put("Contact Lead Source", "Newsletter");
        createContactData[2].put("Contact Tags", "Designer");

        return createContactData;
    }

    public HashMap<String, String>[] generateDataForUpdateContact()
    {
        generateArrayOfHashMaps(editContactData);
        editContactData[0].put("Company Type", "Existing");
        editContactData[0].put("Contact Name", "Nirmal");
        editContactData[0].put("Contact Email", UtilityClass.emailGenerator());
        editContactData[0].put("Contact LinkedinUrl", "");
        editContactData[0].put("Company", PropertyFileWriter.readFile("config.properties","Company_Name"));
        editContactData[0].put("Contact Telephone", "67824755");
        editContactData[0].put("Contact Mobile", "556244356");
        editContactData[0].put("Contact Designation", "Team Lead");
        editContactData[0].put("Contact Lead Source", "Newsletter-Updated");
        editContactData[0].put("Contact Tags", "2023");
        editContactData[0].put("Company Tags", "Architects");

        editContactData[1].put("Company Type", "Without Company");
        editContactData[1].put("Contact Name", "Rishab");
        editContactData[1].put("Contact Email", UtilityClass.emailGenerator());
        editContactData[1].put("Contact LinkedinUrl", "https://www.linkedin.com/rishab");
        editContactData[1].put("Contact Telephone", "979824755");
        editContactData[1].put("Contact Mobile", "23620044356");
        editContactData[1].put("Contact Designation", "Marketing Lead");
        editContactData[1].put("Contact Lead Source", "Indeed");
        editContactData[1].put("Contact Tags", "Dubai Expo");

        editContactData[2].put("Company Type", "New Company");
        editContactData[2].put("Contact Name", "Vybhav");
        editContactData[2].put("Contact Email", UtilityClass.emailGenerator());
        editContactData[2].put("Contact LinkedinUrl", "https://www.linkedin.com/Vybhav");
        editContactData[2].put("Contact Designation", "Customer Relations");
        editContactData[2].put("Contact Tags", "Functional");
        editContactData[2].put("Company", UtilityClass.companyNameGenerator());
        editContactData[2].put("Company Industry Type", "Manufacturer");
        editContactData[2].put("Company City", "Dubai");
        editContactData[2].put("Company Website", "https://www.company3.com");
        editContactData[2].put("Company Tags", "aesthetic");
        editContactData[2].put("Company Address", "B block,Silicon oasis");
        editContactData[2].put("Company State", "Dubai");
        editContactData[2].put("Company Zip", "00927");
        editContactData[2].put("Company Country", "United Arab Emirates");

        return editContactData;
    }

   

}