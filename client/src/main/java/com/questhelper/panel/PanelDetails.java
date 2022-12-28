package com.questhelper.panel;

import com.questhelper.requirements.Requirement;
import com.questhelper.requirements.item.ItemRequirement;
import com.questhelper.steps.NpcStep;
import com.questhelper.steps.QuestStep;

import java.util.ArrayList;
import java.util.List;

public class PanelDetails {
    public <T> PanelDetails(String s, List<T> asList, Requirement... requirements) {
    }

    public <T> PanelDetails(String s, List<T> asList, List<Requirement> requirements) {
    }

    public PanelDetails(String s, QuestStep step) {
    }

    public PanelDetails(String quests, List<Object> emptyList, ArrayList<ItemRequirement> itemRequirements, ArrayList<ItemRequirement> itemRequirements1) {
    }

    public <T> PanelDetails(String starting_off, List<T>... lists) {
    }

    public <T> PanelDetails(String getting_back_into_west_ardougne, List<T> asList) {
    }

    public PanelDetails(String getting_the_distillator, QuestStep... enterBackyardOfHeadquarters) {
    }

    public void setLockingStep(QuestStep ardyStrawTask) {
    }

    public void setDisplayCondition(Requirement notArdyStraw) {
    }

    public void addSteps(QuestStep terrorDog) {
    }

    public void setVars(int i) {
    }

    public void setVars(int i, int i1, int i2, int i3, int i4, int i5, int i6) {
    }
}
