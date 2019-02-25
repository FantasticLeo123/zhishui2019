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
        item5.setHeadTitle("Calm");
        item5.setPersonMessage("Usus de bassus buxum, desiderium index!");
        item5.setPersonName("Gao Qi");
        item5.setListItems(prepareContentsArray5());
        dataset.add(item5);

        CardData item4 = new CardData();
        item4.setMainBackgroundResource(R.drawable.city_scape);
        item4.setHeadBackgroundResource(R.drawable.city_scape_head);
        item4.setHeadTitle("Angry");
        item4.setPersonMessage("Solems manducare, tanquam neuter verpa.");
        item4.setPersonName("Huang Yan");
        item4.setListItems(prepareContentsArray4());
        dataset.add(item4);

        CardData item3 = new CardData();
        item3.setMainBackgroundResource(R.drawable.cuisine);
        item3.setHeadBackgroundResource(R.drawable.cuisine_head);
        item3.setHeadTitle("Upset");
        item3.setPersonMessage("Magnum lacteas ducunt ad orexis.");
        item3.setPersonName("Li Hao");
        item3.setListItems(prepareContentsArray3());
        dataset.add(item3);

        CardData item2 = new CardData();
        item2.setMainBackgroundResource(R.drawable.nature);
        item2.setHeadBackgroundResource(R.drawable.nature_head);
        item2.setHeadTitle("Anxious");
        item2.setPersonName("Si Keyi");
        item2.setPersonMessage("Nunquam perdere clabulare.");
        item2.setListItems(prepareContentsArray2());
        dataset.add(item2);

        CardData item1 = new CardData();
        item1.setMainBackgroundResource(R.drawable.night_life);
        item1.setHeadBackgroundResource(R.drawable.night_life_head);
        item1.setHeadTitle("Sad");
        item1.setPersonMessage("Cur adelphis studere?");
        item1.setPersonName("Yu Renshu");
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
                new Content("What is innovation?", R.string.content1),
                new Content("What is innovation?", R.string.content1),
                new Content("What is innovation?", R.string.content1)));
        return contents.subList(0, 3);

    }

    private List<Content> prepareContentsArray2() {
        List<Content> contents = new ArrayList<>();
        contents.addAll(Arrays.asList(
                new Content("Why is innovation?", R.string.content1),
                new Content("Why is innovation?", R.string.content1),
                new Content("What is innovation?", R.string.content1)));
        return contents.subList(0, 3);

    }

    private List<Content> prepareContentsArray3() {
        List<Content> contents = new ArrayList<>();
        contents.addAll(Arrays.asList(
                new Content("What is innovation?", R.string.content1),
                new Content("What is innovation?", R.string.content1),
                new Content("What is innovation?", R.string.content1)));
        return contents.subList(0, 3);

    }

    private List<Content> prepareContentsArray4() {
        List<Content> contents = new ArrayList<>();
        contents.addAll(Arrays.asList(
                new Content("What is innovation?", R.string.content1),
                new Content("What is innovation?", R.string.content1),
                new Content("What is innovation?", R.string.content1)));
        return contents.subList(0, 3);

    }

    private List<Content> prepareContentsArray5() {
        List<Content> contents = new ArrayList<>();
        contents.addAll(Arrays.asList(
                new Content("What is innovation?", R.string.content1),
                new Content("What is innovation?", R.string.content1),
                new Content("What is innovation?", R.string.content1)));
        return contents.subList(0, 3);

    }
}
