package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int team_a_score = 0;
    private int team_b_score = 0;

    // this is a better way to fix the point increments
    private enum ShootScore {
        THREE_POINTER(3), TWO_POINTER(2), FREE_THROW(1);

        private final int points;

        private ShootScore(int points) {
            this.points = points;
        }

        public int getPoints() {
            return points;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForTeamA();
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA() {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(team_a_score));
    }

    /**
     * Displays the given score for Team B
     */
    public void displayForTeamB() {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(team_b_score));
    }


    /**
     * Called when a score is updated
     */
    public void updateScoreForTeam(ShootScore x, String team) {
        switch (team) {
            case "Team A":
                team_a_score += x.getPoints();
                displayForTeamA();
                break;

            case "Team B":
                team_b_score += x.getPoints();
                displayForTeamB();
                break;

            default:
                System.err.println("ERROR: No such team. Score update failed.");
        }
    }


    /**
     * Called when any update score button is clicked
     */
    public void updateScoreForTeam(View updateButton) {
        int btnid = updateButton.getId();

        switch (btnid) {
            // Team A scores three points
            case R.id.btn_teama_3pts:
                updateScoreForTeam(ShootScore.THREE_POINTER, "Team A");
                break;

            // Team A scores two points
            case R.id.btn_teama_2pts:
                updateScoreForTeam(ShootScore.TWO_POINTER, "Team A");
                break;

            // Team A scored free throw
            case R.id.btn_teama_1pts:
                updateScoreForTeam(ShootScore.FREE_THROW, "Team A");
                break;

            // Team B scores three points
            case R.id.btn_teamb_3pts:
                updateScoreForTeam(ShootScore.THREE_POINTER, "Team B");
                break;

            // Team B scores two points
            case R.id.btn_teamb_2pts:
                updateScoreForTeam(ShootScore.TWO_POINTER, "Team B");
                break;

            // Team B scored free throw
            case R.id.btn_teamb_1pts:
                updateScoreForTeam(ShootScore.FREE_THROW, "Team B");
                break;

            default:
                System.out.println("Invalid button!");
        }
    }

    /**
     * Reset both teams scores
     */
    public void resetTeamScores(View view) {
        team_a_score = 0;
        team_b_score = 0;
        displayForTeamA();
        displayForTeamB();
    }

}
