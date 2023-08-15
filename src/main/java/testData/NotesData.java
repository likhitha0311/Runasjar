package testData;

import java.util.HashMap;

public class NotesData extends BaseData{
    public HashMap<String, String>[] createNotesValidationMessages =new HashMap[3];

    public HashMap<String, String>[] createNotesNegativeTestData =new HashMap[3];

    public HashMap<String, String>[] editNotesValidationMessages =new HashMap[3];

    public HashMap<String, String>[] editNotesNegativeTestData =new HashMap[3];

    public HashMap<String, String>[]  createNotesData= new HashMap[2];;

    public HashMap<String, String>[]  updateNotesData= new HashMap[2];;


    public void generateArrayOfHashMaps(HashMap<String,String>[] dataSet)
    {

        for (int i = 0; i < dataSet.length; i++)
        {
            dataSet[i] = new HashMap<String,String>();

        }
    }
    public HashMap<String, String>[] generateDataForCreateNotesNegativeTesting(){
        generateArrayOfHashMaps(createNotesNegativeTestData);
        createNotesNegativeTestData[0].put("Notes", "");
        createNotesNegativeTestData[0].put("Attachment", "src\\test\\resources\\Companylist.xlsx");

        createNotesNegativeTestData[1].put("Notes", "Contact Notes");
        createNotesNegativeTestData[1].put("Attachment", "src\\test\\resources\\Invalidfileformat.wmv");

        createNotesNegativeTestData[2].put("Notes", "");
        createNotesNegativeTestData[2].put("Attachment", "src\\test\\resources\\Invalidfileformat.wmv");
        return createNotesNegativeTestData;


    }
    public HashMap<String, String>[] generateAddNotesValidationMessages(){
        generateArrayOfHashMaps(createNotesValidationMessages);
        createNotesValidationMessages[0].put("Notes", "Note is required");

        createNotesValidationMessages[1].put("File Type Error", "File format is not supported.");

        createNotesValidationMessages[2].put("Notes", "Note is required");
        createNotesValidationMessages[2].put("File Type Error", "File format is not supported.");

        return createNotesValidationMessages;


    }

    public HashMap<String, String>[] generateDataForEditNotesNegativeTesting(){
        generateArrayOfHashMaps(editNotesNegativeTestData);
        editNotesNegativeTestData[0].put("Notes", "");
        editNotesNegativeTestData[0].put("Attachment", "src\\test\\resources\\Companylist.xlsx");

        editNotesNegativeTestData[1].put("Notes", "Contact Notes");
        editNotesNegativeTestData[1].put("Attachment", "src\\test\\resources\\Invalidfileformat.wmv");

        editNotesNegativeTestData[2].put("Notes", "");
        editNotesNegativeTestData[2].put("Attachment", "src\\test\\resources\\Invalidfileformat.wmv");
        return editNotesNegativeTestData;


    }
    public HashMap<String, String>[] generateEditNotesValidationMessages(){
        generateArrayOfHashMaps(editNotesValidationMessages);
        editNotesValidationMessages[0].put("Notes", "Note is required");

        editNotesValidationMessages[1].put("File Type Error ", "File format is not supported.");

        editNotesValidationMessages[2].put("Notes", "Note is required");
        editNotesValidationMessages[2].put("File Type Error ", "File format is not supported.");

        return editNotesValidationMessages;


    }


    public HashMap<String, String>[] generateDataForCreateNotes()
    {
        generateArrayOfHashMaps(createNotesData);
        createNotesData[0].put("Notes", "Test Notes functionality");
        createNotesData[0].put("Attachment", "src\\test\\resources\\Companylist.xlsx");

        createNotesData[1].put("Notes", "The palette is minimal. White and shades of blue painted walls, white-washed tambour panel, blue upholstery and concrete flooring provide a canvas for Brainium to develop truly special moments in the space with colorful, interactive digital art, while also relating to the urban views. ");
        createNotesData[1].put("Attachment", "src\\test\\resources\\sample.pdf");
        return createNotesData;


    }

    public HashMap<String, String>[] generateDataForUpdateNotes() {
        generateArrayOfHashMaps(updateNotesData);
        updateNotesData[0].put("Notes", "Test Notes Update functionality");

        updateNotesData[1].put("Notes", "Updated Notes");
        updateNotesData[1].put("Attachment", "src\\test\\resources\\ContactList.xlsx");

        return updateNotesData;


    }

}