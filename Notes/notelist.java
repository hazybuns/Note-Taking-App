package Notes;
import java.util.*;

/*
 *  Members: 
 *    Cabonegro, Venz Jan A.
 *    Tan, Herod Jan B.
 *    Opiso, Charls John V.
 * 
 *  Date: 
 *    October 21, 2022
 * 
 *  Title of the Project: 
 *    Note-Taking Application
 * 
 */

public class notelist extends noteinfo {

    private List<noteinfo>noteList = new ArrayList<>(); // ARRAY LIST
    public static Scanner Scanner = new Scanner(System.in); // DECLARATION OF SCANNER
    public static String Title, Contents, IntChoose; // DECLARATION OF VARIABLES THAT WIL BE USED IN THE PROGRAM
    public static int choose; // DECLARATION OF VARIABLES THAT WIL BE USED IN THE PROGRAM

    public notelist() {
        super(Title, Contents); // PARENT CLASS THAT IS BEING INHERITED FROM - NOTES AND CONTENTS
    }
    
    public void ExistingNotes() // A METHOD THAT CONSISTS EXISTING NOTES
    {
        noteinfo newnote1 = new noteinfo("Shopping List", "\n-1 Tray Eggs \n-5 kg Chicken Drumsticks \n-Milk \n-Oil \n-Marinade Ingredients \n-Ham \n-Bread \n-Butter \n-Soy Sauce \n-Vinegar");
        noteinfo newnote2 = new noteinfo("Failure", "\nI can accept failure. Everyone fails at something. But I can't accept not trying. \n\n- Michael Jordan");
        noteList.add(newnote1);
        noteList.add(newnote2);
    }

    private void AddNotesMethod() { // THE METHOD THAT HAS THE FUNCTION TO ADD NOTES
        System.out.println("\nNote Taking App - Add Note");
        System.out.print("\nEnter Title: ");
        Scanner.nextLine();
        Title = Scanner.nextLine();
    
        for(noteinfo notes : noteList) {

            // AFTER ENTERING THE TITLE THE CODE BELOW EXECUTES AND IF IT MATCHES >>
            // THE EXISTING NOTES THEN IT WILL NOT PROCEED TO THE NEXT STEP >>
            // AND WILL PROMPT TO ASK THE USER TO TRY AGAIN A DIFFERENT TITLE

            if(notes.getTitle().equals(Title)) {
                System.out.println("\nNote Title Already Existed! Please Use A Unique Title.");
                System.out.println("\n\n===========[TRY AGAIN!!]===========\n\n\n");
                MainMethod();
            }
        }
        // AND IF THE TITLE IS UNIQUE THEN IT WILL PROCEED TO THE ADDING OF THE CONTENT OF THE NOTES
    
        System.out.print("\nEnter Contents: ");
        Contents = Scanner.nextLine();

        // AFTER COMPLETING THE FOLLOWING, THE CODE BELOW EXECUTES THEN >>
        // IT WILL ADD THE NOTE IN OUR ARRAYLIST 

        noteinfo notes = new noteinfo(Title, Contents); //CREATES NEW OBJECT = NOTE with its contents.
        noteList.add(notes);
        System.out.println("\n\n===========[YOU'VE SUCCESSFULLY ADDED A NOTE!]===========\n\n\n");

        Ask(); // CALLS THE METHOD ASK
    }

    private void Ask() { // THE METHOD THAT ASK THE USER TO ADD AGAIN A NOTE OR TO RETURN TO THE MAIN MENU

        System.out.println("\nWant To Add More Note?\n\n[1] Yes [2] No, Return to Main Menu");
        System.out.println("\n\nPlease Input Numbers Only: ");
        IntChoose = Scanner.next();

        // IF THE USER INPUTTED AN INTEGER THEN IT WILL NOT EXECUTE THE CATCH CODE >>
        // AND IF THE USER INPUTTED A NON-INTEGER THE THE CATCH CODE WILL EXECUTE >>
        // THEN IT WILL PROMPT THE USER TO TRY AGAIN

        try { 
            choose = Integer.parseInt(IntChoose);
        } catch (Exception e) {
            System.out.println("\nNot A Defined Input.");
            System.out.println("\n\n===========[PLEASE TRY AGAIN!!]===========\n\n");
            Ask();
        }

        switch(choose) {

            case 1: // CALLS THE ADD NOTE METHOD
                AddNotesMethod();
                break;
           
            case 2: // CALLS THE MAIN METHOD
                MainMethod();
                break;

            default: // IF THE USER INPUTTED A CHOICE THAT IS NOT DEFINED (1 AND 2) THEN >>
                     // THE CODE BELOW WILL EXECUTE AND WILL PROMPT THE USER TO TRY AGAIN
                System.out.println("\nNot A Defined Input, Please Input [1] or [2] Only.");
                System.out.println("\n\n===========[TRY AGAIN!!]===========\n\n\n");
                Ask(); // CALLS THE METHOD ASK                
        }
    }

    private void ShowMethod() { // A METHOD THAT WILL SHOW ALL THE EXISTING NOTES

        System.out.println("\n\nNote Taking App - Show All Notes");

        System.out.println("\nATTENTION!! IF IT DOESN'T SHOW ANY NOTES, "
        + "THEN IT MEANS THAT IT DOESN'T HAVE ANY EXISTING NOTES AND FOR IT TO DIPLAYS A NOTE YOU NEED TO "
        + "ADD A NOTE!\n\n");

        System.out.println("\n===========[DISPLAYING NOTES]===========\n");

        for(noteinfo notes : noteList) { // TO ITERATE THE ELEMENTS(NOTES) IN THE PROGRAM'S ARRAYLIST

            System.out.print("\nTitle: " + notes.getTitle() // PRINTS THE TITLE EXISTING IN THE ARRAYLIST >>
            +"\nContents: " + notes.getContents()           // ALONG WITH ITS CONTENTS
            +"\n\n\n");
        }
        MainMethod(); // CALLS THE MAIN METHOD - TO RETRUN IN THE MAIN MENU
    }

    private void DeleteMethod() { // THE METHOD THAT HAS THE FUNCTION TO DELETE A NOTE

        System.out.print("\nEnter Note Title to Delete: ");
        Scanner.nextLine();
        Title = Scanner.nextLine();

        Iterator<noteinfo>itr = noteList.iterator(); // TO ITERATE THE ELEMENTS(NOTES) IN THE PROGRAM'S ARRAYLIST

        while(itr.hasNext()) { // IT CHECKS IF THE ARRAYLIST HAS MORE ELEMENTS
            // next() - RETURNS THE NEXT ELEMENT IN THE ITERATION

            // THE CODE BELOW WILL COMPARE THE "Title" THAT IS INPUTTED BY THE USER TO THE TITLE THAT IS >>
            // EXISTING IN THIS PROGRAM AND IF IT MATCHES THE TITLE THAT EXIST THEN IT WILL >>
            // EXECUTE THE itr.remove WHICH WILL REMOVE THE NOTE THAT PASSED THE CONDITION.

            // condition below ↓↓↓↓↓
            if(itr.next().getTitle().equalsIgnoreCase(Title)) { 
                itr.remove();
                System.out.print("\n\n===========[NOTE SUCCESSFULLY DELETED!]===========\n\n\n");
                return;
            }
            // AND IF THE CONDITION RETURNED FALSE THEN IT WILL EXECUTE THE FOLLOWING CODE BELOW >>
            // THAT PRINTS "NOTE TITLE NOT FOUND! PLEASE TRY AGAIN".
        }
        System.out.println("\n\n===========[NOTE TITLE NOT FOUND! PLEASE TRY AGAIN]===========\n\n\n");
        MainMethod(); // CALLS THE MAIN METHOD TO RETURN TO THE MAIN MENU
    }

    private void FindNoteMethod() { // THE METHOD THAT FIND A SPECIFIC NOTE USING ITS TITLE

        System.out.print("\nEnter Note Title To Find: ");
        Scanner.nextLine();
        String noteSearch = Scanner.nextLine();

        for(noteinfo notes : noteList) { // TO ITERATE THE ELEMENTS(NOTES) IN THE PROGRAM'S ARRAYLIST
            // IF THE DATA THAT IS INPUTTED BY THE USER PASSED THE CONDITION BELOW >>
            // THE IT WILL EXECUTE THE CODE THE WILL DIPLAY/SHOW THE SPECIFIC NOTE >>
            // THAT PASSED THE CONDITION USING ITS TITLE

            if(notes.getTitle().equals(noteSearch)) {
                System.out.println("\n\n===========[NOTE FOUND!]===========\n\n\n");
                System.out.print("\nNote Title: " + notes.getTitle());
                System.out.print("\nContents: " + notes.getContents() + "\n");
                return;
            }
            // AND IF THE CONDITION RETURNED FALSE (doesn't passed the condition) >>
            // THEN IT WILL EXECUTE THE CODE BELOW THAT PRINTS "NOTE NOT FOUND! PLEASE TRY AGAIN"
        }
        System.out.println("\n\n===========[NOTE NOT FOUND! PLEASE TRY AGAIN]===========\n\n\n");
        MainMethod();
    }

    private void UpdateEditNotes() { 
        // THE METHOD THAT HAS THE FUNCTION TO UPDATE/EDIT THE NOTE TITLE AND ITS CONTENTS
    
    while(choose!=99) {

        System.out.println("\n\nWhat do you want to Update? \n[1] :: Title\n[2] :: Content \n[3] :: Return to Main Menu");
        // THE CODE ABOVE PRINTS THE CHOICES THIS METHOD HAS

        System.out.println("\nPlease Input Numbers Only: ");
        IntChoose = Scanner.next();

        try{
            choose = Integer.parseInt(IntChoose);

        /* 
         * THE USER MUST INPUT AN INTEGER ELSE >>
         *  IT WILL EXECUTE THE CODE BELOW THAT WILL PROMPT THE USER TO TRY AGAIN AND ALSO TO AVOID ERRORS 
        */

        }catch(Exception e) {
            System.out.print("\n\n===========[You Selected An Invalid Choice, Please Try Again!]===========\n\n\n");
            UpdateEditNotes(); // CALLS THE UPDATE METHOD TO GO BACK IN THE UPDATE OPTION
        }

        switch(choose) {

            case 1: // a choice that let the user to update the note title the user wants to
                
                System.out.print("\nEnter the Title of the Note to be edited: "); // OLD TITLE TO BE UPDATED
                Scanner.nextLine(); 
                String title = Scanner.nextLine();
        
                for(noteinfo notes : noteList) { 
                // TO ITERATE THE ELEMENTS(NOTES) IN THE PROGRAM'S ARRAYLIST

                    if(notes.getTitle().equals(title)) { 
                    // IF THIS CONDITON RETURNS TRUE THEN >>
                    // THE CODE BELOW WILL EXECUTE
                    
                        System.out.println("\nEnter New Title: "); // NEW TITLE
                        Title = Scanner.nextLine();
                        notes.setTitle(Title); // SETS(update) THE NEW TITLE THAT IS INPUTTED BY THE USER

                        System.out.println("\nYou've Successfully Edited The Title Of This Note");
                        UpdateEditNotes(); // CALLS THE UPDATE METHOD TO GO BACK IN THE UPDATE OPTION

                }
                // AND IF THE CONDITION RETURNED FALSE THEN IT WILL EXECUTE THE CODE BELOW >>
                // AND WILL PROMPT THE USER TO TRY AGAIN
            }
                    System.out.println("\n\n===========[NOTE TITLE NOT FOUND! PLEASE TRY AGAIN]===========\n\n\n");
                    break;

        
            case 2: // a choice that edits the contents of a note that the user wants to
               
                System.out.println("\nEnter The Note Title of the content you want to update: ");
                // ASK THE USER THE TITLE THAT THE USER WANT TO UPDATE ITS CONTENT

                Scanner.nextLine();
                String TITLE = Scanner.nextLine();  
            
                for(int i=0; i<noteList.size(); i++){
                    // TO ITERATE THE ELEMENTS(NOTES) IN THE PROGRAM'S ARRAYLIST

                    if(noteList.get(i).getTitle().equalsIgnoreCase(TITLE)){
                    // IF THIS CONDITON RETURNS TRUE THEN >>
                    // THE CODE BELOW WILL EXECUTE

                        System.out.println("\nEnter New Content: "); // NEW CONTENTS
                        Contents = Scanner.nextLine();
                        noteList.get(i).setContents(Contents); // SETS(updates) THE NEW CONTENT THAT IS INPUTTED BY THE USER

                        System.out.println("\nYou've Successfully Edited The Contents Of This Note");
                        UpdateEditNotes(); // CALLS THE UPDATE METHOD TO GO BACK IN THE UPDATE OPTION
                }
                // AND IF THE CONDITION RETURNED FALSE THEN IT WILL EXECUTE THE CODE BELOW >>
                // AND WILL PROMPT THE USER TO TRY AGAIN
            }
            System.out.println("\n\n===========[NOTE TITLE NOT FOUND! PLEASE TRY AGAIN]===========\n\n\n");
            break;


            case 3: // a choice that will go back to the main menu
            MainMethod();

            default: // if the user inputted an integer(choice) that is not defined then this >>
            // code will execute
            System.out.println("\nNot A Defined Input, Please Input Numbers From 1-3 Only.");
        }
    }
    }
    
    private void Exit() { // THE METHOD THAT HAS THE FUNCTION TO EXIT OR CLOSE THE NOTE-TAKING APPLICATION
        System.out.println("\n\n===========[CLOSED APP SUCCESSFULLY!]===========\n\n\n");
        System.exit(0);
    }

    public void MainMethod() {

        while(true){
            System.out.println("\n===================");
            System.out.println("  NOTE-TAKING APP  ");
            System.out.println("===================");
            System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("|                                 |");
            System.out.println("|  [1] Add Note                   |");
            System.out.println("|  [2] Show All Notes             |");
            System.out.println("|  [3] Delete Note                |");
            System.out.println("|  [4] Find Note                  |");
            System.out.println("|  [5] Update/Edit Note           |");
            System.out.println("|  [6] Exit Note                  |");
            System.out.println("|                                 |");
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("\nEnter Choice (numbers only): ");
            IntChoose = Scanner.next();

            try {
                choose = Integer.parseInt(IntChoose);
            }catch (Exception e){
                System.out.print("\n\n===========[You Selected An Invalid Choice, Please Try Again!]===========\n\n\n");
                MainMethod();
            }
            
            switch(choose){ //will call the functions that the user ask to use

                case 1: 
                    AddNotesMethod(); //add a note
                    break; 
                case 2:
                    ShowMethod(); //show all notes
                    break;
                case 3:
                    DeleteMethod(); //delete a note
                    break;
                case 4:
                    FindNoteMethod(); //find a note
                    break;
                case 5:
                    UpdateEditNotes(); //update a note
                    break;
                case 6:
                    Exit(); // exit the program/app
                    break;
                default:
                System.out.print("\n\n===========[You Selected An Invalid Choice, Please Try Again!]===========\n\n\n");
            }
        }
    }
}