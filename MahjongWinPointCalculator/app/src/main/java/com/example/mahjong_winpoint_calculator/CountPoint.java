package com.example.mahjong_winpoint_calculator;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class CountPoint {
    private int basePoint;
    private int finalPoint;
    private ArrayList<String> handsList;
    private HashMap<String, Integer> handsHashMap;
    private int[] hands;

    private static final String TAG = "CountPointClass";



    public CountPoint(int basePoint, ArrayList<String> hands){
        this.hands = new int[34];
        Arrays.fill(this.hands, 0);
        this.basePoint = basePoint;
        this.hands = listToArray(hands);
        //handsHashMap = new HashMap<String, Integer>();
    }

    public boolean checkHu(){
        CheckHu checkHu = new CheckHu();
        if (hands != null){
            if (checkHu.get_hu_info(hands, 34, 0))
                return true;
            else
                return false;
        }else{
            Log.e(TAG, "hands is null");
            return false;
        }
    }

    private int[] listToArray(ArrayList<String> cardList){
        for (String card : cardList){
            if (card.endsWith("w")){
                int cardNum = Integer.parseInt(card.split("-")[0]);
                for (int i = 0; i < 9; i++){
                    if (cardNum - 1 == i)
                        this.hands[i] = this.hands[i] + 1;
                }
            }else if (card.endsWith("t")){
                int cardNum = Integer.parseInt(card.split("-")[0]);
                for (int i = 0; i < 9; i++){
                    if (cardNum - 1 == i)
                        this.hands[i + 9] = this.hands[i + 9] + 1;
                }
            }else if (card.endsWith("b")){
                int cardNum = Integer.parseInt(card.split("-")[0]);
                for (int i = 0; i < 9; i++){
                    if (cardNum - 1 == i)
                        this.hands[i + 18] = this.hands[i + 18] + 1;
                }
            }else if (card.endsWith("f")){
                String cardName = card.split("-")[0];
                switch (cardName){
                    case "d": this.hands[27] = this.hands[27] + 1; break;
                    case "n": this.hands[28] = this.hands[28] + 1; break;
                    case "x": this.hands[29] = this.hands[29] + 1; break;
                    case "b": this.hands[30] = this.hands[30] + 1; break;
                }
            }else if (card.endsWith("Z")){
                this.hands[31] = this.hands[31] + 1;
            }else if (card.endsWith("F")){
                this.hands[32] = this.hands[31] + 1;
            }else if (card.endsWith("B")){
                this.hands[33] = this.hands[31] + 1;
            }
        }

        return hands;
    }

//    private void handsToHashMap(){
//        if (handsHashMap == null){
//            handsHashMap = new HashMap<>();
//        }
//        if (!hands.isEmpty()){
//            for (String cardName : hands){
//                Integer count = handsHashMap.get(cardName);
//                if (count == null)
//                    handsHashMap.put(cardName, 1);
//                else
//                    handsHashMap.put(cardName, count + 1);
//            }
//        }
//        for (String card : handsHashMap.keySet()){
//            if (card.endsWith("w")){
//                int cardNum = Integer.parseInt(card.split("-")[0]);
//                if (handsHashMap.containsKey((cardNum+1)+"-w") && handsHashMap.containsKey((cardNum+2)+"-w")){
//                    handsHashMap.put(card, handsHashMap.get(card) + 2);
//                    handsHashMap.put(((cardNum + 1)+"-w"), handsHashMap.get(((cardNum+1)+"-w")) - 1);
//                    handsHashMap.put(((cardNum + 2)+"-w"), handsHashMap.get(((cardNum+2)+"-w")) - 1);
//                }else if (handsHashMap.containsKey((cardNum-1)+"-w") && handsHashMap.containsKey((cardNum+1)+"-w")){
//                    handsHashMap.put(card, handsHashMap.get(card) - 1);
//                    handsHashMap.put(((cardNum - 1)+"-w"), handsHashMap.get(((cardNum-1)+"-w")) + 2);
//                    handsHashMap.put(((cardNum + 1)+"-w"), handsHashMap.get(((cardNum+1)+"-w")) - 1);
//                }else if (handsHashMap.containsKey((cardNum-1)+"-w") && handsHashMap.containsKey((cardNum-2)+"-w")){
//                    handsHashMap.put(card, handsHashMap.get(card) - 1);
//                    handsHashMap.put(((cardNum - 2)+"-w"), handsHashMap.get(((cardNum-2)+"-w")) + 2);
//                    handsHashMap.put(((cardNum - 1)+"-w"), handsHashMap.get(((cardNum-1)+"-w")) - 1);
//                }
//                Iterator<Integer> it = handsHashMap.values().iterator();
//                while (it.hasNext()) {
//                    if (it.next().compareTo(0) == 0)
//                        it.remove();
//                }
//            }
//        }
    //   }

//    private void calculatePoint(){
//        handsToHashMap();
//    }

//    public boolean containCards(ArrayList<String> hands, String... cards){
//        for (String card : cards){
//            if (!hands.contains(card))
//                return false;
//        }
//        return true;
//    }

    public int getFinalPoint(){
        return finalPoint;
    }

//    public void print(){
//        for (String name: handsHashMap.keySet()){
//            String key = name.toString();
//            int value = handsHashMap.get(name);
//            System.out.println(key + " " + value);
//        }
//    }

//    public static void main(String[] args) {
//        ArrayList<String> test = new ArrayList<String>(Arrays.asList("1-w","2-w","3-w","4-w","4-w","4-w","7-w","6-w","5-w","8-w","8-w","8-w", "9-w","9-w"));
//        CountPoint cp = new CountPoint(10,test);
//        if (cp.checkValid()){
//            cp.calculatePoint();
//            cp.print();
//        }
//    }


}
