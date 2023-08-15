package testData;

import java.util.HashMap;

public class DocumentsData extends BaseData{

    public HashMap<String, String>[] addDocumentsData= new HashMap[2];;

    public HashMap<String, String>[] editDocumentsData= new HashMap[2];;

    public HashMap<String, String>[] addDocumentsValidationMessages=new HashMap[1];
    public HashMap<String, String>[] addDocumentsNegativeTestData=new HashMap[1];

    public void generateArrayOfHashMaps(HashMap<String,String>[] dataSet)
    {

        for (int i = 0; i < dataSet.length; i++)
        {
            dataSet[i] = new HashMap<String,String>();

        }
    }

    public HashMap<String, String>[] generateDataForAddDocuments() {
        generateArrayOfHashMaps(addDocumentsData);

        addDocumentsData[1].put("Attachment", "src\\test\\resources\\Contactlist.xlsx");

        addDocumentsData[0].put("Attachment", "src\\test\\resources\\sample.pdf");
        return addDocumentsData;


    }

    public HashMap<String, String>[] generateDataForEditDocuments() {
        generateArrayOfHashMaps(editDocumentsData);

        editDocumentsData[0].put("Document Type", "Brochure");
        editDocumentsData[0].put("Document Description","This is a brochure");

        editDocumentsData[1].put("Document Type", "Specifications");
        editDocumentsData[1].put("Document Description","This is a Specification Document ");
        return editDocumentsData;


    }

    public HashMap<String, String>[]  generateDataForAddDocumentsNegativeTesting() {
        generateArrayOfHashMaps(addDocumentsNegativeTestData);

        addDocumentsNegativeTestData[0].put("Attachment", "src\\test\\resources\\Invalidfileformat.wmv");

        return addDocumentsNegativeTestData;


    }

    public HashMap<String, String>[] generateAddDocumentsValidationMessages(){
        generateArrayOfHashMaps(addDocumentsValidationMessages);

        addDocumentsValidationMessages[0].put("File Type Error", "File format is not supported.");

        return addDocumentsValidationMessages;


    }
}