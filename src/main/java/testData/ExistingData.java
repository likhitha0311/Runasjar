package testData;

import util.PropertyFileWriter;
import util.UtilityClass;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Properties;

public class ExistingData extends BaseData {

    public HashMap<String, String>[] createExistingCompanyData = new HashMap[1];

    public HashMap<String, String>[] createExistingContactData = new HashMap[1];

    public void generateArrayOfHashMaps(HashMap<String, String>[] dataSet) {
        for (int i = 0; i < dataSet.length; i++) {
            dataSet[i] = new HashMap<String, String>();
        }
    }

    public HashMap<String, String>[] generateDataForCreateCompany()
    {
        generateArrayOfHashMaps(createExistingCompanyData);
        createExistingCompanyData[0].put("Company Name", UtilityClass.companyNameGenerator());
        createExistingCompanyData[0].put("Company Industry Type", "Designer");
        createExistingCompanyData[0].put("Company City", "Vanceburg");
        createExistingCompanyData[0].put("Company Website", "https://www.company.com");
        createExistingCompanyData[0].put("Company Tags", "Architects");
        createExistingCompanyData[0].put("Company Telephone", "88889977");
        createExistingCompanyData[0].put("Company Fax", "0806752424");
        createExistingCompanyData[0].put("Company Email", "Company" + UtilityClass.emailGenerator());
        createExistingCompanyData[0].put("Company Address", "4586 North Bend River Road");
        createExistingCompanyData[0].put("Company State", "Kentucky");
        createExistingCompanyData[0].put("Company Zip", "41179");
        createExistingCompanyData[0].put("Company Country", "Egypt");
        PropertyFileWriter.writeFile("config.properties", "Company_Name", createExistingCompanyData[0].get("Company Name"));
        return createExistingCompanyData;
    }

    public HashMap<String, String>[] generateDataForCreateContact()
    {
        generateArrayOfHashMaps(createExistingContactData);
        createExistingContactData[0].put("Company Type", "New Company");
        createExistingContactData[0].put("Contact Name", "Karan");
        createExistingContactData[0].put("Contact Email", UtilityClass.emailGenerator());
        createExistingContactData[0].put("Contact Tags", "Designer");
        createExistingContactData[0].put("Company", UtilityClass.companyNameGenerator());
        createExistingContactData[0].put("Company Industry Type", "Designer");
        createExistingContactData[0].put("Company City", "Vanceburg");
        createExistingContactData[0].put("Company Website", "https://www.company.com");
        createExistingContactData[0].put("Company Tags", "Architects");
        createExistingContactData[0].put("Company Telephone", "88889977");
        createExistingContactData[0].put("Company Fax", "0806752424");
        createExistingContactData[0].put("Company Email", "Company" + UtilityClass.emailGenerator());
        createExistingContactData[0].put("Company Address", "4586 North Bend River Road");
        createExistingContactData[0].put("Company State", "Kentucky");
        createExistingContactData[0].put("Company Zip", "41179");
        createExistingContactData[0].put("Company Country", "Egypt");
        PropertyFileWriter.writeFile("config.properties", "Contact_Email", createExistingContactData[0].get("Contact Email"));
        System.out.println(createExistingContactData);
        return createExistingContactData;
    }
}