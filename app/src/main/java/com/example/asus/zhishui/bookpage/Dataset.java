package com.example.asus.zhishui.bookpage;

import com.ramotion.expandingcollection.ECCardData;
import com.example.asus.zhishui.bookpage.pojo.CardData;
import com.example.asus.zhishui.bookpage.pojo.Content;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import com.example.asus.zhishui.R;

public class Dataset {

    private List<ECCardData> dataset;
    public Dataset() {
        dataset = new ArrayList<>(5);

        CardData item5 = new CardData();
        item5.setMainBackgroundResource(R.drawable.attractions);
        item5.setHeadBackgroundResource(R.drawable.attractions_head);
        item5.setHeadTitle("Relaxed");
        item5.setPersonMessage("If you do what you love, it is the best way to relax.");
        item5.setPersonName("Christian Louboutin");
        item5.setListItems(prepareContentsArray5());
        dataset.add(item5);

        CardData item4 = new CardData();
        item4.setMainBackgroundResource(R.drawable.city_scape);
        item4.setHeadBackgroundResource(R.drawable.city_scape_head);
        item4.setHeadTitle("Angry");
        item4.setPersonMessage("Negative emotions are big, flashing signs that something needs to change.");
        item4.setPersonName("Gretchen Rubin");
        item4.setListItems(prepareContentsArray4());
        dataset.add(item4);

        CardData item3 = new CardData();
        item3.setMainBackgroundResource(R.drawable.cuisine);
        item3.setHeadBackgroundResource(R.drawable.cuisine_head);
        item3.setHeadTitle("Depressed");
        item3.setPersonMessage("You can choose to not let little things upset you.");
        item3.setPersonName("Joel Osteen");
        item3.setListItems(prepareContentsArray3());
        dataset.add(item3);

        CardData item2 = new CardData();
        item2.setMainBackgroundResource(R.drawable.nature);
        item2.setHeadBackgroundResource(R.drawable.nature_head);
        item2.setHeadTitle("Anxious");
        item2.setPersonName("Olive Schreiner");
        item2.setPersonMessage("No good work is ever done while the heart is hot and anxious and fretted.");
        item2.setListItems(prepareContentsArray2());
        dataset.add(item2);

        CardData item1 = new CardData();
        item1.setMainBackgroundResource(R.drawable.night_life);
        item1.setHeadBackgroundResource(R.drawable.night_life_head);
        item1.setHeadTitle("Panic");
        item1.setPersonMessage("Stay in control, and never panic.");
        item1.setPersonName("Martha Stewart");
        item1.setListItems(prepareContentsArray1());
        dataset.add(item1);

    }

    public List<ECCardData> getDataset() {
        Collections.shuffle(dataset);
        return dataset;
    }



    private List<Content> prepareContentsArray1() {
        List<Content> contents = new ArrayList<>();
        contents.addAll(Arrays.asList(
                new Content("What is a panic attack?", R.string.panic1),
                new Content("When do panic attacks happen?", R.string.panic2),
                new Content("What is innovation?", R.string.panic3)));
        return contents.subList(0, 3);

    }

    private List<Content> prepareContentsArray2() {
        List<Content> contents = new ArrayList<>();
        contents.addAll(Arrays.asList(
                new Content("How can I deal with pressure?", R.string.stress1),
                new Content("How can I become more emotionally resilient?", R.string.stress2),
                new Content("What treatments are there for stress?", R.string.stress3)));
        return contents.subList(0, 3);

    }

    private List<Content> prepareContentsArray3() {
        List<Content> contents = new ArrayList<>();
        contents.addAll(Arrays.asList(
                new Content("Look after yourself", R.string.depression1),
                new Content("Practice self-care", R.string.depression2),
                new Content("Keep active", R.string.depression3),
                new Content("Challenge your low mood", R.string.depression4),
                new Content("Connect with other people", R.string.depression5)));
        return contents.subList(0, 3);

    }

    private List<Content> prepareContentsArray4() {
        List<Content> contents = new ArrayList<>();
        contents.addAll(Arrays.asList(
                new Content("What is unhelpful angry behaviour?", R.string.angry1),
                new Content("How can I manage an outburst?", R.string.angry2),
                new Content("How can I control my anger long term?", R.string.angry3)));
        return contents.subList(0, 3);

    }

    private List<Content> prepareContentsArray5() {
        List<Content> contents = new ArrayList<>();
        contents.addAll(Arrays.asList(
                new Content("Relax your body", R.string.relax1),
                new Content("Get creative", R.string.relax2),
                new Content("Listen music", R.string.relax3)));
        return contents.subList(0, 3);

    }
}
