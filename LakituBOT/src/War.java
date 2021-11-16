/**
 * 
 * @author Hippolyte "Redsilver" BERNARD
 *
 */
public class War {
	
	private static Integer yourTeamScore = 0;
	private static Integer oppTeamScore = 0;
	private static Integer genDiff = 0;
	
	private static Integer yourScores[] = new Integer[12];
	private static Integer oppScores[] = new Integer[12];

	/**
	 * Set scores for each map, delete previous points in case of change
	 */
	public static void setScores() {
		
		for (int i = 0;i<12;i++) {
			if (isMapFinished(i)) {
			
			Integer yourTeamScoreThisMap = LakituGUI.checkMapScore(i);
			Integer oppTeamScoreThisMap = 82-yourTeamScoreThisMap;
			Integer diff = yourTeamScoreThisMap - oppTeamScoreThisMap;
			
			/**
			 * Remove previous scores
			 */	
<<<<<<< HEAD
			setYourTeamScore(yourTeamScore - yourScores[i]);
			setOppTeamScore(oppTeamScore - oppScores[i]);
			
			/**
			 * Register map scores and add map scores to general score
			 */
			yourScores[i]=yourTeamScoreThisMap;
			oppScores[i] = 82-yourTeamScoreThisMap;			
			setYourTeamScore(yourTeamScore + yourTeamScoreThisMap);
			setOppTeamScore(oppTeamScore + oppTeamScoreThisMap);
			setGenDiff(yourTeamScore-oppTeamScore);
			
			
			/**
			 * Set label texts
			 */
			LakituGUI.genScore.setText(yourTeamScore.toString()+" - "+oppTeamScore.toString()+" ("+genDiff.toString()+")");
			LakituGUI.score[i].setText(yourTeamScoreThisMap.toString()+" - "+oppTeamScoreThisMap.toString()+" ("+diff.toString()+")");
			}
		}
	}
	
	/**
	 * Initializes all scores to zero 
	 */
	public static void initScores() {
		for(int i=0;i<yourScores.length;i++) {
			yourScores[i]=0;
			oppScores[i]=0;
		}
	}
	
	/**
	 * Check if map is finished by verifying the number of checked checkboxes
	 * @param map, the number of the map
	 * @return true if there are 6 checked boxes on the map line
	 */
	public static boolean isMapFinished(Integer map) {
		
		if (LakituGUI.lineCount(map)==6) {
			return true;
		}
		
		return false;
	}

	public static void setYourTeamScore(Integer yourTeamScore) {
		War.yourTeamScore = yourTeamScore;
	}

	public static void setOppTeamScore(Integer oppTeamScore) {
		War.oppTeamScore = oppTeamScore;
	}

	public static void setGenDiff(Integer genDiff) {
		War.genDiff = genDiff;
=======
			yourTeamScore -= yourScores[i];
			oppTeamScore -= oppScores[i];
			
			/**
			 * Register map scores and add map scores to general score
			 */
			yourScores[i]=yourTeamScoreThisMap;
			oppScores[i] = 82-yourTeamScoreThisMap;			
			yourTeamScore += yourTeamScoreThisMap;
			oppTeamScore += oppTeamScoreThisMap;
			genDiff = yourTeamScore-oppTeamScore;
			
			
			/**
			 * Set label texts
			 */
			LakituGUI.genScore.setText(yourTeamScore.toString()+" - "+oppTeamScore.toString()+" ("+genDiff.toString()+")");
			LakituGUI.score[i].setText(yourTeamScoreThisMap.toString()+" - "+oppTeamScoreThisMap.toString()+" ("+diff.toString()+")");
			}
		}
	}
	
	/**
	 * Initializes all scores to zero 
	 */
	public static void initScores() {
		for(int i=0;i<yourScores.length;i++) {
			yourScores[i]=0;
			oppScores[i]=0;
		}
	}
	
	/**
	 * Check if map is finished by verifying the number of checked checkboxes
	 * @param map, the number of the map
	 * @return true if there are 6 checked boxes on the map line
	 */
	public static boolean isMapFinished(Integer map) {
		
		if (LakituGUI.lineCount(map)==6) {
			return true;
		}
		
		return false;
>>>>>>> branch 'master' of https://github.com/Rxdsilver/LakituBot
	}
}
