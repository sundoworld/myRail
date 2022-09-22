package myRail;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.util.*;


public class myRail extends MIDlet implements CommandListener {
	//data base
	//               south, north
	int[][] bound = { {  0, 45 },
	                  {  4, 34 },
	                  {  6, 32 },
	                  {  8, 30 },
	                  { 10, 28 },
	                  { 12, 26 },
	                  { 14, 24 },
	                  { 19, 19 },
	                  { 21, 17 },
	                  { 23, 15 },
	                  { 25, 13 },
	                  { 27, 11 },
	                  { 29,  9 },
	                  { 30,  8 },
	                  { 33,  5 },
	                  { 35,  3 },
	                  { 45,  0 } };

	int[][] msb_start_sundays = 
	      { { -1, -1, -1, -1, -1, -1 },
            { -1, -1, -1, -1, -1, -1 },
            { -1, -1, -1, -1, -1, -1 },
            { -1, -1, -1, -1, -1, -1 },
            { -1, -1, -1, -1, -1, -1 },
            { -1, -1, -1, -1, -1, -1 },
            {  0, 20, 40, -1, -1, -1 },
            {  0, 20, 40, -1, -1, -1 },
            {  0, 20, 40, -1, -1, -1 },
            {  0, 20, 40, 50, -1, -1 },
            {  0, 20, 40, -1, -1, -1 },
            {  0, 20, 40, -1, -1, -1 },
            {  0, 20, 40, -1, -1, -1 },
            {  0, 20, 40, -1, -1, -1 },
            {  0, 20, 40, -1, -1, -1 },
            {  0, 20, 40, -1, -1, -1 },
            {  0, 20, 40, -1, -1, -1 },
            {  0, 20, 40, -1, -1, -1 },
            {  0, 20, 40, -1, -1, -1 },
            {  0, 20, 40, -1, -1, -1 },
            {  0, 20, 40, -1, -1, -1 },
            {  0, 20, 40, -1, -1, -1 },
            {  0, 20, -1, -1, -1, -1 },
            { -1, -1, -1, -1, -1, -1 } };
	
	int[][] msb_start_weekdays = 
    { { -1, -1, -1, -1, -1, -1 },
      { -1, -1, -1, -1, -1, -1 },
      { -1, -1, -1, -1, -1, -1 },
      { -1, -1, -1, -1, -1, -1 },
      { 10, 40, -1, -1, -1, -1 },
      { 10, 30, 50, -1, -1, -1 },
      {  5, 20, 40, 55, -1, -1 },
      { 15, 30, 45, -1, -1, -1 },
      {  0, 15, 25, 35, 45, 55 },
      {  5, 15, 25, 35, 45, 55 },
      {  5, 15, 30, 45, -1, -1 },
      {  0, 15, 30, 45, -1, -1 },
      {  5, 25, 45, -1, -1, -1 },
      {  5, 25, 45, -1, -1, -1 },
      {  5, 25, 45, -1, -1, -1 },
      {  5, 25, 45, -1, -1, -1 },
      {  0, 15, 30, 45, -1, -1 },
      {  0, 15, 30, 40, 50, -1 },
      {  0, 15, 25, 35, 45, 55 },
      { 10, 25, 40, -1, -1, -1 },
      {  0, 20, 40, -1, -1, -1 },
      {  0, 20, 40, -1, -1, -1 },
      {  0, 20, -1, -1, -1, -1 },
      { -1, -1, -1, -1, -1, -1 } };
	
	int[][] vlcy_start_sundays = 
    { { -1, -1, -1, -1, -1, -1 },
      { -1, -1, -1, -1, -1, -1 },
      { -1, -1, -1, -1, -1, -1 },
      { -1, -1, -1, -1, -1, -1 },
      { -1, -1, -1, -1, -1, -1 },
      { -1, -1, -1, -1, -1, -1 },
      {  50, -1, -1, -1, -1, -1 },
      {  10, 30, 50, -1, -1, -1 },
      {  10, 30, 50, -1, -1, -1 },
      {  10, 30, 50, -1, -1, -1 },
      {  10, 30, 40, 50, -1, -1 },
      {  10, 30, 50, -1, -1, -1 },
      {  10, 30, 50, -1, -1, -1 },
      {  10, 30, 50, -1, -1, -1 },
      {  10, 30, 50, -1, -1, -1 },
      {  10, 30, 50, -1, -1, -1 },
      {  10, 30, 50, -1, -1, -1 },
      {  10, 30, 50, -1, -1, -1 },
      {  10, 30, 50, -1, -1, -1 },
      {  10, 30, 50, -1, -1, -1 },
      {  10, 30, 50, -1, -1, -1 },
      {  10, 30, 50, -1, -1, -1 },
      {  10, 30, 50, -1, -1, -1 },
      {  10, -1, -1, -1, -1, -1 } };
	
	int[][] vlcy_start_weekdays = 
    { { -1, -1, -1, -1, -1, -1 },
      { -1, -1, -1, -1, -1, -1 },
      { -1, -1, -1, -1, -1, -1 },
      { -1, -1, -1, -1, -1, -1 },
      { -1, -1, -1, -1, -1, -1 },
      {  0, 30, 45, -1, -1, -1 },
      {  5, 25, 40, 55, -1, -1 },
      { 10, 25, 40, 55, -1, -1 },
      { 10, 20, 35, 50, -1, -1 },
      {  5, 15, 25, 35, 50, -1 },
      {  5, 15, 30, 45, -1, -1 },
      {  0, 15, 35, 55, -1, -1 },
      { 15, 35, 55, -1, -1, -1 },
      { 15, 35, 55, -1, -1, -1 },
      { 15, 35, 55, -1, -1, -1 },
      {  5, 25, 45, -1, -1, -1 },
      {  0, 10, 25, 40, 55, -1 },
      {  5, 15, 25, 35, 45, 55 },
      {  5, 20, 30, 45, -1, -1 },
      {  0, 10, 20, 30, 50, -1 },
      { 10, 30, 50, -1, -1, -1 },
      { 10, 30, 50, -1, -1, -1 },
      { 10, 30, 50, -1, -1, -1 },
      { 10, -1, -1, -1, -1, -1 } };
	
	int[][] active_station_chart= new int[24][7];
	int[][] final_chart= new int[3][2];
	// Settings
	Form form = new Form("myRail 1.0");
    Display display;
    //ChoiceGroup(label,type,elements,image)
    ChoiceGroup ServicePOP = new ChoiceGroup ("Days of Service", Choice.POPUP,
            new String[] {"Sunday", "Weekdays"}, null);
    ChoiceGroup StationListPOP = new ChoiceGroup ("Station", Choice.POPUP,
        new String[] {"Chennai Beach", "Chennai Fort", "Park Town", "Chintadripet", "Chepauk", "Thiruvallikeni", "Light House", "Thirumayilai", "Mandaveli", "Greenways Road", "Kotturpuram", "Kasturba Nagar", "Indira Nagar", "Thiruvanmiyur", "Tharamani", "Perungudi", "Velachery"}, null);
    ChoiceGroup BoundToPOP = new ChoiceGroup ("Bound to", Choice.POPUP,
        new String[] {"South", "North"}, null);
    static final Command CMD_SCREEN = new Command("Go", Command.SCREEN, 0);
    static final Command CMD_EXIT = new Command("Close", Command.EXIT, 1);
    
    public myRail() {
		// TODO Auto-generated constructor stub
    	//String msg = "Welcome to Sun World's myRail.\n";
        //form.append(msg);
    	form.append(ServicePOP);
        form.append(StationListPOP);
        form.append(BoundToPOP);
        //form.append("First and Last Trains at Terminus[W/S]:\nChennai Beach:\nW0410-W2220\nS0600-S2220\nVelachery:\nW0500-W2310\nS0650-S2310\n\nCredits:\nSundaresan V\nsundaresanv@hotmail.com\n ");
	}

	protected void destroyApp(boolean arg0) throws MIDletStateChangeException {
		// TODO Auto-generated method stub
		notifyDestroyed();
	}

	protected void pauseApp() {
		// TODO Auto-generated method stub

	}

	protected void startApp() throws MIDletStateChangeException {
		// TODO Auto-generated method stub
		display = Display.getDisplay(this);
        form.addCommand(CMD_SCREEN);
        form.addCommand(CMD_EXIT);
        form.setCommandListener(this);
        display.setCurrent(form);
	}
	
	public void screenDisp() {
        // TODO Auto-generated method stub
		Calendar calendar = Calendar.getInstance();
	    calendar.getTime();
	    int week_day = calendar.get(Calendar.DAY_OF_WEEK);
	    int hour = calendar.get(Calendar.HOUR_OF_DAY);
	    int minute = calendar.get(Calendar.MINUTE);
        int bound_to = BoundToPOP.getSelectedIndex();
        int station = StationListPOP.getSelectedIndex();
       
        int offset=bound[station][bound_to];
        int flag=0,y=0,z=0,secret=61,i,j;
        for (i=0;i<24;i++) {
        	for (j=0;j<7;j++) {
        		active_station_chart[i][j]=-1;
        	}
        }
        if (week_day !=1) {
        	if (bound_to == 1) { //north bound
        		System.out.println("\n Weekdays North Bound");
        		for (i=0;i<24;i++) {
        			if(secret<60) {
        				 flag=0;
        			}
        			for (j=0;j<6;j++) {
        				if(msb_start_weekdays[i][j] != -1) {
        					if ( msb_start_weekdays[i][j]+offset < 60 ) {
        						if ( flag == 0 ) {
        							//System.out.println("Smaller");
        							active_station_chart[i][j]=msb_start_weekdays[i][j]+offset;
        							y=0;
        						}
        						else if ( flag == 1 && y == 1) {
        							//System.out.println("  Smaller after Greater");
        							active_station_chart[i][j+1]=msb_start_weekdays[i][j]+offset;
        							z=2;
        						}
        						else if ( flag == 2 && y == 1) {
        							//System.out.println("  Smaller after Greater after Greater");
        							active_station_chart[i][j+2]=msb_start_weekdays[i][j]+offset;
        	                    }
        					}
        					else if ( msb_start_weekdays[i][j]+offset >= 60 ) {
        						if ( flag == 1 && y == 1 && z!=2) {
        							//System.out.println("    Greater after Greater");
        							active_station_chart[i+1][1]=msb_start_weekdays[i][j]+offset-60;
        							flag=2;
        						} 
        						else if ( flag == 1 && y == 1 && z==2) {
        							//System.out.println(" Greater after smaller");
        							active_station_chart[i+1][0]=msb_start_weekdays[i][j]+offset-60;
        							flag=1;
        							z=11;
        						}
        						else if ( flag == 0 || (flag ==2 && y==1 && z==11)) {
        							//System.out.println(" Greater");
        							active_station_chart[i+1][0]=msb_start_weekdays[i][j]+offset-60;
        							flag=1;
        						}
        						y=1;
        					 }
        					 //System.out.println(" flag="+flag+" y="+y+" z="+z);
        					 secret=msb_start_weekdays[i][j]+offset;
        				} 
        				else {
        						//ctrl comes here when value is -1	
        				}
        			}//column 'for' ends here
        		}//row 'for' ends here
        	}
        	else {  //south bound
        		System.out.println("\n Weekdays South Bound");
        		for (i=0;i<24;i++) {
        			if(secret<60) {
        				 flag=0;
        			}
        			for (j=0;j<6;j++) {
        				if(msb_start_weekdays[i][j] != -1) {
        					if ( msb_start_weekdays[i][j]+offset < 60 ) {
        						if ( flag == 0 ) {
        							//System.out.println("Smaller");
        							active_station_chart[i][j]=msb_start_weekdays[i][j]+offset;
        							y=0;
        						}
        						else if ( flag == 1 && y == 1) {
        							//System.out.println("  Smaller after Greater");
        							active_station_chart[i][j+1]=msb_start_weekdays[i][j]+offset;
        							z=2;
        						}
        						else if ( flag == 2 && y == 1) {
        							//System.out.println("  Smaller after Greater after Greater");
        							active_station_chart[i][j+2]=msb_start_weekdays[i][j]+offset;
        	                    }
        					}
        					else if ( msb_start_weekdays[i][j]+offset >= 60 ) {
        						if ( flag == 1 && y == 1 && z!=2) {
        							//System.out.println("    Greater after Greater");
        							active_station_chart[i+1][1]=msb_start_weekdays[i][j]+offset-60;
        							flag=2;
        						} 
        						else if ( flag == 1 && y == 1 && z==2) {
        							//System.out.println(" Greater after smaller");
        							active_station_chart[i+1][0]=msb_start_weekdays[i][j]+offset-60;
        							flag=1;
        							z=11;
        						}
        						else if ( flag == 0 || (flag ==2 && y==1 && z==11)) {
        							//System.out.println(" Greater");
        							active_station_chart[i+1][0]=msb_start_weekdays[i][j]+offset-60;
        							flag=1;
        						}
        						y=1;
        					 }
        					 //System.out.println(" flag="+flag+" y="+y+" z="+z);
        					 secret=msb_start_weekdays[i][j]+offset;
        				} 
        				else {
        						//ctrl comes here when value is -1	
        				}
        			}//column 'for' ends here
        		}//row 'for' ends here
        	}//Bound_to if case
        } //Weekdays if case
        else { //Sunday if case
        	if (bound_to == 1) { //north bound
        		System.out.println("\n Sunday North Bound");
        		for (i=0;i<24;i++) {
        			if(secret<60) {
        				 flag=0;
        			}
        			for (j=0;j<6;j++) {
        				if(vlcy_start_sundays[i][j] != -1) {
        					if ( vlcy_start_sundays[i][j]+offset < 60 ) {
        						if ( flag == 0 ) {
        							//System.out.println("Smaller");
        							active_station_chart[i][j]=vlcy_start_sundays[i][j]+offset;
        							y=0;
        						}
        						else if ( flag == 1 && y == 1) {
        							//System.out.println("  Smaller after Greater");
        							active_station_chart[i][j+1]=vlcy_start_sundays[i][j]+offset;
        							z=2;
        						}
        						else if ( flag == 2 && y == 1) {
        							//System.out.println("  Smaller after Greater after Greater");
        							active_station_chart[i][j+2]=vlcy_start_sundays[i][j]+offset;
        	                    }
        					}
        					else if ( vlcy_start_sundays[i][j]+offset >= 60 ) {
        						if ( flag == 1 && y == 1 && z!=2) {
        							//System.out.println("    Greater after Greater");
        							active_station_chart[i+1][1]=vlcy_start_sundays[i][j]+offset-60;
        							flag=2;
        						} 
        						else if ( flag == 1 && y == 1 && z==2) {
        							//System.out.println(" Greater after smaller");
        							active_station_chart[i+1][0]=vlcy_start_sundays[i][j]+offset-60;
        							flag=1;
        							z=11;
        						}
        						else if ( flag == 0 || (flag ==2 && y==1 && z==11)) {
        							//System.out.println(" Greater");
        							active_station_chart[i+1][0]=vlcy_start_sundays[i][j]+offset-60;
        							flag=1;
        						}
        						y=1;
        					 }
        					 //System.out.println(" flag="+flag+" y="+y+" z="+z);
        					 secret=vlcy_start_sundays[i][j]+offset;
        				} 
        				else {
        						//ctrl comes here when value is -1	
        				}
        			}//column 'for' ends here
        		}//row 'for' ends here
        	}
        	else {  //south bound
        		System.out.println("\n Sunday South Bound");
        		for (i=0;i<24;i++) {
        			if(secret<60) {
        				 flag=0;
        			}
        			for (j=0;j<6;j++) {
        				if(msb_start_sundays[i][j] != -1) {
        					if ( msb_start_sundays[i][j]+offset < 60 ) {
        						if ( flag == 0 ) {
        							//System.out.println("Smaller");
        							active_station_chart[i][j]=msb_start_sundays[i][j]+offset;
        							y=0;
        						}
        						else if ( flag == 1 && y == 1) {
        							//System.out.println("  Smaller after Greater");
        							active_station_chart[i][j+1]=msb_start_sundays[i][j]+offset;
        							z=2;
        						}
        						else if ( flag == 2 && y == 1) {
        							//System.out.println("  Smaller after Greater after Greater");
        							active_station_chart[i][j+2]=msb_start_sundays[i][j]+offset;
        	                    }
        					}
        					else if ( msb_start_sundays[i][j]+offset >= 60 ) {
        						if ( flag == 1 && y == 1 && z!=2) {
        							//System.out.println("    Greater after Greater");
        							active_station_chart[i+1][1]=msb_start_sundays[i][j]+offset-60;
        							flag=2;
        						} 
        						else if ( flag == 1 && y == 1 && z==2) {
        							//System.out.println(" Greater after smaller");
        							active_station_chart[i+1][0]=msb_start_sundays[i][j]+offset-60;
        							flag=1;
        							z=11;
        						}
        						else if ( flag == 0 || (flag ==2 && y==1 && z==11)) {
        							//System.out.println(" Greater");
        							active_station_chart[i+1][0]=msb_start_sundays[i][j]+offset-60;
        							flag=1;
        						}
        						y=1;
        					 }
        					 //System.out.println(" flag="+flag+" y="+y+" z="+z);
        					 secret=msb_start_sundays[i][j]+offset;
        				} 
        				else {
        						//ctrl comes here when value is -1	
        				}
        			}//column 'for' ends here
        		}//row 'for' ends here
        	}
        }
        
        System.out.println(" STATION="+station+" Bound To="+bound_to+" week_day="+week_day+" hour="+hour+" minute="+minute);
        int count=0,x,index;
		for (j=0;j<7;j++) {
			if ( active_station_chart[hour][j] >= minute && count < 3 ) {
				final_chart[count][0]=hour;
				final_chart[count][1]=active_station_chart[hour][j];
				count++;	
			}
		}
		System.out.println(" count="+count);
		if ( count < 3 ){
			index=3-count;
			for (x=0;x<index;x++){
				System.out.println(" count="+count+" x="+x);
				if ( active_station_chart[hour+1][x] != -1 ) {
					final_chart[count][0]=hour+1;
					final_chart[count][1]=active_station_chart[hour+1][x];
				}
				else if ( active_station_chart[hour+1][x] == -1 ) {
					final_chart[count][0]=99;
					final_chart[count][1]=99;
				}
				count++;
				System.out.println(" +count="+count+" +x="+x);
			}
		}
		for(i=0;i<3;i++){
			for(j=0;j<2;j++){
				System.out.println(" final="+final_chart[i][j]);
			}
		}
        String text = "myRail.\nNow: ".concat(String.valueOf(final_chart[0][0])).concat(":").concat(String.valueOf(final_chart[0][1])).concat("\nNext: ").concat(String.valueOf(final_chart[1][0])).concat(":").concat(String.valueOf(final_chart[1][1])).concat("\nLater: ").concat(String.valueOf(final_chart[2][0])).concat(":").concat(String.valueOf(final_chart[2][1])).concat("\n\nSunW0rld Inc..\nCopyright 2013");
        System.out.println(text);
        if( (bound_to == 0 && station == 16) || (bound_to == 1 && station == 0) )
        {
        	text = "myRail.\nIts a Terminus in MRTS.\n\nSunW0rld Inc..\nCopyright 2013";
        }
        Alert a = new Alert("Information", text, null, AlertType.INFO);
        display.setCurrent(a);
	}
	 
	public void commandAction(Command cmd, Displayable disp) {
		if (cmd == CMD_EXIT) {
			notifyDestroyed();
		}
		if (cmd == CMD_SCREEN) {
			screenDisp();
		}
	}

}
