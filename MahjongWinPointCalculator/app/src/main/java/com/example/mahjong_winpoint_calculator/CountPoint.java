package com.example.mahjong_winpoint_calculator;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;


public class CountPoint {
    private int basePoint;
    private int finalPoint;
    private int[] hands;
    private String huPai;
    private boolean ziMo;
    private ArrayList<String> chi;
    private ArrayList<String> peng;
    private ArrayList<String> mingGang;
    private ArrayList<String> anGang;
    //private ArrayList<String> mingKe;
    private ArrayList<String> anKe;
    private boolean menQianQing;
    private boolean danDiaoJiang;

    private static final String TAG = "CountPointClass";
    private ArrayList<String> fanXings;

    public CountPoint(int basePoint, ArrayList<String> hands, String huPai, boolean ziMo, ArrayList<String> chi, ArrayList<String> peng, ArrayList<String> mingGang, ArrayList<String> anGang, ArrayList<String> anKe, boolean menQianQing, boolean danDiaoJiang){
        this.hands = new int[34];
        Arrays.fill(this.hands, 0);
        this.basePoint = basePoint;
        listToArray(hands, this.hands);
        this.fanXings = new ArrayList<>();
        this.huPai = huPai;
        this.ziMo = ziMo;
        this.chi = chi;
        this.peng = peng;
        this.mingGang = mingGang;
        this.anGang = anGang;
        this.menQianQing = menQianQing;
        this.anKe = anKe;
        this.danDiaoJiang = danDiaoJiang;
    }

    public boolean checkHu(){
        CheckHu checkHu = new CheckHu();
        if (hands != null){
            if (checkHu.get_hu_info(hands, 34, 0))
                return true;
            else
                return false;
        }else{
            return false;
        }
    }

    private void listToArray(ArrayList<String> cardList, int[] array){
        for (String card : cardList){
            if (card.endsWith("w")){
                int cardNum = Integer.parseInt(card.split("-")[0]);
                for (int i = 0; i < 9; i++){
                    if (cardNum - 1 == i)
                        array[i] = array[i] + 1;
                }
            }else if (card.endsWith("t")){
                int cardNum = Integer.parseInt(card.split("-")[0]);
                for (int i = 0; i < 9; i++){
                    if (cardNum - 1 == i)
                        array[i + 9] = array[i + 9] + 1;
                }
            }else if (card.endsWith("b")){
                int cardNum = Integer.parseInt(card.split("-")[0]);
                for (int i = 0; i < 9; i++){
                    if (cardNum - 1 == i)
                        array[i + 18] = array[i + 18] + 1;
                }
            }else if (card.endsWith("f")){
                String cardName = card.split("-")[0];
                switch (cardName){
                    case "d": array[27] = array[27] + 1; break;
                    case "n": array[28] = array[28] + 1; break;
                    case "x": array[29] = array[29] + 1; break;
                    case "b": array[30] = array[30] + 1; break;
                }
            }else if (card.endsWith("Z")){
                array[31] = array[31] + 1;
            }else if (card.endsWith("F")){
                array[32] = array[32] + 1;
            }else if (card.endsWith("B")){
                array[33] = array[33] + 1;
            }
        }
    }

    public ArrayList<String> calculate_final_point(){
        fanXings.clear();
        ArrayList<String> paiXingResult = new ArrayList<>();
        if (isDaSiXi(hands)){
            fanXings.add("DaSiXi");
            paiXingResult.add("大四喜");
        }
        if(isDaSanYuan(hands)){
            fanXings.add("DaSanYuan");
            paiXingResult.add("大三元");
        }
        if(isLvYiSe(hands)){
            fanXings.add("LvYiSe");
            paiXingResult.add("绿一色");
        }
        if(isJiuLianBaoDeng(hands)){
            fanXings.add("JiuLianBaoDeng");
            paiXingResult.add("九莲宝灯");
        }
        if(isSiGang(hands)){
            fanXings.add("SiGang");
            paiXingResult.add("四杠");
        }if(isLianQiDui(hands)){
            fanXings.add("LianQiDui");
            paiXingResult.add("连七对");
        }if(isShiSanYao(hands)){
            fanXings.add("ShiSanYao");
            paiXingResult.add("十三幺");
        }if(isQingYaoJiu(hands)){
            fanXings.add("QingYaoJiu");
            paiXingResult.add("清幺九");
        }if(isXiaoSiXi(hands)){
            fanXings.add("XiaoSiXi");
            paiXingResult.add("小四喜");
        }if(isXiaoSanYuan(hands)){
            fanXings.add("XiaoSanYuan");
            paiXingResult.add("小三元");
        }if(isZiYiSe(hands)){
            fanXings.add("ZiYiSe");
            paiXingResult.add("字一色");
        }if(isSiAnKe(hands)){
            fanXings.add("SiAnKe");
            paiXingResult.add("四暗刻");
        }if(isYiSeShuangLongHui(hands)){
            fanXings.add("YiSeShuangLongHui");
            paiXingResult.add("一色双龙会");
        }if(isYiSeSiTongShun(hands)){
            fanXings.add("YiSeSiTongShun");
            paiXingResult.add("一色四同顺");
        }if(isYiSeSiJieGao(hands)){
            fanXings.add("YiSeSiJieGao");
            paiXingResult.add("一色四节高");
        }if(isYiSeSiBuGao(hands)){
            fanXings.add("YiSeSiBuGao");
            paiXingResult.add("一色四步高");
        }if(isSanGang(hands)){
            fanXings.add("SanGang");
            paiXingResult.add("三杠");
        }if(isHunYaoJiu(hands)){
            fanXings.add("HunYaoJiu");
            paiXingResult.add("混幺九");
        }if(isQiDui(hands)){
            fanXings.add("QiDui");
            paiXingResult.add("七对");
        }if(isQiXingBuKao(hands)){
            fanXings.add("QiXingBuKao");
            paiXingResult.add("七星不靠");
        }if(isQuanShuangKe(hands)){
            fanXings.add("QuanShuangKe");
            paiXingResult.add("全双刻");
        }if(isYiSeSanTongShun(hands)){
            fanXings.add("YiSeSanTongShun");
            paiXingResult.add("一色三同顺");
        }if(isYiSeSanJieGao(hands)){
            fanXings.add("YiSeSanJieGao");
            paiXingResult.add("一色三节高");
        }if(isQuanDa(hands)){
            fanXings.add("QuanDa");
            paiXingResult.add("全大");
        }if(isQuanZhong(hands)){
            fanXings.add("QuanZhong");
            paiXingResult.add("全中");
        }if(isQingLong(hands)){
            fanXings.add("QingLong");
            paiXingResult.add("清龙");
        }if(isSanSeShuangLongHui(hands)){
            fanXings.add("SanSeShuangLongHui");
            paiXingResult.add("三色双龙会");
        }if(isYiSeSanBuGao(hands)){
            fanXings.add("YiSeSanBuGao");
            paiXingResult.add("一色三步高");
        }if(isQuanBuKao(hands)){
            fanXings.add("QuanBuKao");
            paiXingResult.add("全不靠");
        }if(isZuHeLong(hands)){
            fanXings.add("ZuHeLong");
            paiXingResult.add("组合龙");
        }if(isSanFengKe(hands)){
            fanXings.add("SanFengKe");
            paiXingResult.add("三风刻");
        }if(isSanSeSanTongShun(hands)){
            fanXings.add("SanSeSanTongShun");
            paiXingResult.add("三色三同顺");
        }if(isSanSeSanJieGao(hands)){
            fanXings.add("SanSeSanJieGao");
            paiXingResult.add("三色三节高");
        }if(isSanSeSanBuGao(hands)){
            fanXings.add("SanSeSanBuGao");
            paiXingResult.add("三色三步高");
        }

        if (isQuanXiao(hands)){
            fanXings.add("QuanXiao");
            paiXingResult.add("全小");
        }
        if (isQingYiSe(hands)){
            fanXings.add("QingYiSe");
            paiXingResult.add("清一色");
        }
        if (isQuanDaiWu(hands)){
            fanXings.add("QuanDaiWu");
            paiXingResult.add("全带五");
        }
        if (isSanTongKe(hands)){
            fanXings.add("SanTongKe");
            paiXingResult.add("三同刻");
        }
        if (isSanAnKe(hands)){
            fanXings.add("SanAnKe");
            paiXingResult.add("三暗刻");
        }
        if (isDaYuWu(hands)){
            fanXings.add("DaYuWu");
            paiXingResult.add("大于五");
        }
        if (isXiaoYuWu(hands)){
            fanXings.add("XiaoYuWu");
            paiXingResult.add("小于五");
        }
        if (isHuaLong(hands)){
            fanXings.add("HuaLong");
            paiXingResult.add("花龙");
        }
        if (isTuiBuDao(hands)){
            fanXings.add("TuiBuDao");
            paiXingResult.add("推不倒");
        }
        if (isHaiDiLaoYue(hands)){
            fanXings.add("HaiDiLaoYue");
            paiXingResult.add("海底捞月");
        }
        if (isGangShangKaiHua(hands)){
            fanXings.add("GangShangKaiHua");
            paiXingResult.add("杠上开花");
        }
        if (isQiangGangHu(hands)){
            fanXings.add("QiangGangHu");
            paiXingResult.add("抢杠胡");
        }
        if (isPengPengHu(hands)){
            fanXings.add("PengPengHu");
            paiXingResult.add("碰碰胡");
        }
        if (isHunYiSe(hands)){
            fanXings.add("HunYiSe");
            paiXingResult.add("混一色");
        }
        if (isWuMenQi(hands)){
            fanXings.add("WuMenQi");
            paiXingResult.add("五门齐");
        }
        if (isQuanQiuRen(hands)){
            fanXings.add("QuanQiuRen");
            paiXingResult.add("全求人");
        }
        if (isShuangAnGang(hands)){
            fanXings.add("ShuangAnGang");
            paiXingResult.add("双暗杠");
        }
        if (isShuangJianKe(hands)){
            fanXings.add("ShuangJianKe");
            paiXingResult.add("双箭刻");
        }
        if (isQuanDaiYao(hands)){
            fanXings.add("QuanDaiYao");
            paiXingResult.add("全带幺");
        }
        if (isBuQiuRen(hands)){
            fanXings.add("BuQiuRen");
            paiXingResult.add("不求人");
        }
        if (isShuangMingGang(hands)){
            fanXings.add("ShuangMingGang");
            paiXingResult.add("双明杠");
        }
        if (isHuJueZhang(hands)){
            fanXings.add("HuJueZhang");
            paiXingResult.add("胡绝张");
        }
        if (isJianKe(hands)){
            fanXings.add("JianKe");
            paiXingResult.add("箭刻");
        }
        if (isQuanFengKe(hands)){
            fanXings.add("QuanFengKe");
            paiXingResult.add("圈风刻");
        }
        if (isMenFengKe(hands)){
            fanXings.add("MenFengKe");
            paiXingResult.add("门风刻");
        }
        if (isMenQianQing(hands)){
            fanXings.add("MenQianQing");
            paiXingResult.add("门前清");
        }
        if (isPingHu(hands)){
            fanXings.add("PingHu");
            paiXingResult.add("平胡");
        }
        if (isSiGuiYi(hands)){
            fanXings.add("SiGuiYi");
            paiXingResult.add("四归一");
        }
        if (isShuangTongKe(hands)){
            fanXings.add("ShuangTongKe");
            paiXingResult.add("双同刻");
        }
        if (isShuangAnKe(hands)){
            fanXings.add("ShuangAnKe");
            paiXingResult.add("双暗刻");
        }
        if (isAnGang(hands)){
            fanXings.add("AnGang");
            paiXingResult.add("暗杠");
        }
        if (isDuanYao(hands)){
            fanXings.add("DuanYao");
            paiXingResult.add("断幺");
        }
        if (isYiBanGao(hands)){
            fanXings.add("YiBanGao");
            paiXingResult.add("一般高");
        }
        if (isXiXiangFeng(hands)){
            fanXings.add("XiXiangFeng");
            paiXingResult.add("喜相逢");
        }
        if (isLianLiu(hands)){
            fanXings.add("LianLiu");
            paiXingResult.add("连六");
        }
        if (isLaoShaoFu(hands)){
            fanXings.add("LaoShaoFu");
            paiXingResult.add("老少副");
        }
        if (isYaoJiuKe(hands)){
            fanXings.add("YaoJiuKe");
            paiXingResult.add("幺九刻");
        }
        if (isMingGang(hands)){
            fanXings.add("MingGang");
            paiXingResult.add("明杠");
        }
        if (isQueYiMen(hands)){
            fanXings.add("QueYiMen");
            paiXingResult.add("缺一门");
        }
        if (isWuZi(hands)){
            fanXings.add("WuZi");
            paiXingResult.add("无字");
        }
        if (isBianZhang(hands)){
            fanXings.add("BianZhang");
            paiXingResult.add("边张");
        }
        if (isKanZhang(hands)){
            fanXings.add("KanZhang");
            paiXingResult.add("坎张");
        }
        if (isDanDiaoJiang(hands)){
            fanXings.add("DanDiaoJiang");
            paiXingResult.add("单钓将");
        }
        if (isZiMo(hands)){
            fanXings.add("ZiMo");
            paiXingResult.add("自摸");
        }
        if (isHuaPai(hands)){
            fanXings.add("HuaPai");
            paiXingResult.add("花牌");
        }
        if (isWuFanHu(hands)){
            fanXings.add("WuFanHu");
            paiXingResult.add("无番胡");
        }
        return paiXingResult;
    }

    private boolean isHuaPai(int[] hands) {
        // TODO ask user for input
        return false;
    }

    private boolean isZiMo(int[] hands) {
        if (fanXings.contains("MiaoShouHuiChun") || fanXings.contains("GangShangKaiHua") || fanXings.contains("BuQiuRen"))
            return false;
        // TODO ask user for input
        return ziMo;
    }

    private boolean isDanDiaoJiang(int[] hands) {
        if (fanXings.contains("LianQiDui") || fanXings.contains("QuanQiuRen") || fanXings.contains("SiGang") || fanXings.contains("QiDui") ||
                fanXings.contains("ShiSanYao") || fanXings.contains("QiXingBuKao") || fanXings.contains("QuanBuKao"))
            return false;
        // TODO ask user for input 单调一张将牌

//        int[] temp = new int[34];
//        Arrays.fill(temp,0);
//        listToArray(new ArrayList<String>(List.of(huPai)), temp);
//        int index = 0;
//        for (int ele : temp){
//            if (ele == 1){
//                break;
//            }
//            index ++;
//        }
//        return hands[index] == 2;
        return danDiaoJiang;
    }

    private boolean isKanZhang(int[] hands) {
        // TODO ask user for input 胡两张牌之间的牌，3_5胡4
        return false;
    }

    private boolean isBianZhang(int[] hands) {
        // TODO ask user for input 胡3或者7
        return false;
    }

    private boolean isWuZi(int[] hands) {
        if (fanXings.contains("LianQiDui") || fanXings.contains("QingYaoJiu") || fanXings.contains("YiSeShuangLongHui") || fanXings.contains("ShuangQuanKe") || fanXings.contains("QingYiSe") ||
                fanXings.contains("QuanDa") || fanXings.contains("QuanZhong") || fanXings.contains("QuanXiao") || fanXings.contains("QuanDaiWu") || fanXings.contains("DaYuWu") ||
                fanXings.contains("XiaoYuWu") || fanXings.contains("PingHu") || fanXings.contains("DuanYao") || fanXings.contains("JiuLianBaoDeng"))
            return false;
        return isAllZero(hands,27,33);
    }

    private boolean isQueYiMen(int[] hands) {
        if (fanXings.contains("LianQiDui") || fanXings.contains("XiaoSanYuan") || fanXings.contains("XiaoSiXi") || fanXings.contains("ZiYiSe") || fanXings.contains("YiSeShuangLongHui") ||
                fanXings.contains("YiSeSiTongShun") || fanXings.contains("YiSeSiJieGao") || fanXings.contains("YiSeSiBuGao") || fanXings.contains("QingYiSe") || fanXings.contains("SanFengKe") ||
                fanXings.contains("TuiBuDao") || fanXings.contains("HunYiSe"))
            return false;
        return (!isAllZero(hands,0,8) && !isAllZero(hands,9,17) && isAllZero(hands,18,26)) || (!isAllZero(hands,0,8) && !isAllZero(hands,18,26) && isAllZero(hands,9,17)) ||
                (!isAllZero(hands,9,17) && !isAllZero(hands,18,26) && isAllZero(hands,0,8));
    }

    private boolean isMingGang(int[] hands) {
        if (fanXings.contains("SiGang") || fanXings.contains("SanGang") || fanXings.contains("ShuangMingGang"))
            return false;
        return !mingGang.isEmpty();
    }

    private boolean isYaoJiuKe(int[] hands) {
        if (fanXings.contains("DaSiXi") || fanXings.contains("JiuLianBaoDeng") || fanXings.contains("QingYaoJiu") || fanXings.contains("XiaoSiXi") || fanXings.contains("ZiYiSe") ||
                fanXings.contains("HunYaoJiu") || fanXings.contains("QuanFengKe") || fanXings.contains("MenFengKe"))
            return false;
        return hands[0] == 3 || hands[8] == 3 || hands[9] == 3 || hands[17] == 3 || hands[18] == 3 || hands[26] == 3 || hands[27] == 3 || hands[28] == 3 || hands[29] == 3 || hands[30] == 3;
    }

    private boolean isLaoShaoFu(int[] hands) {
        if (fanXings.contains("YiSeShuangLongHui") || fanXings.contains("SanSeShuangLongHui") || fanXings.contains("QingLong"))
            return false;
        return (hands[0] >= 1 && hands[1] >= 1 && hands[2] >= 1 && hands[6] >= 1 && hands[7] >= 1 && hands[8] >= 1) || (hands[9] >= 1 && hands[10] >= 1 && hands[11] >= 1 && hands[15] >= 1 && hands[16] >= 1 && hands[17] >= 1) ||
                (hands[18] >= 1 && hands[19] >= 1 && hands[20] >= 1 && hands[24] >= 1 && hands[25] >= 1 && hands[26] >= 1);
    }

    private boolean isLianLiu(int[] hands) {
        if (fanXings.contains("QingLong") || fanXings.contains("LianQiDui"))
            return false;
        for (int i =0; i<=3; i++){
            if (hands[i] >= 1 && hands[i+1] >= 1 && hands[i+2] >= 1 && hands[i+3] >= 1 && hands[i+4] >= 1 && hands[i+5] >= 1)  //万
                return true;
        }
        for (int i =9; i<=12; i++){
            if (hands[i] >= 1 && hands[i+1] >= 1 && hands[i+2] >= 1 && hands[i+3] >= 1 && hands[i+4] >= 1 && hands[i+5] >= 1)  //饼
                return true;
        }
        for (int i =18; i<=21; i++){
            if (hands[i] >= 1 && hands[i+1] >= 1 && hands[i+2] >= 1 && hands[i+3] >= 1 && hands[i+4] >= 1 && hands[i+5] >= 1)  //条
                return true;
        }
        return false;
    }

    private boolean isXiXiangFeng(int[] hands) {
        if (fanXings.contains("SanSeShuangLongHui") || fanXings.contains("SanSeSanTongShun"))
            return false;
        int[] temp = new int[34];
        int[] copyOfHand = hands.clone();
        Arrays.fill(temp, 0);

        if (!anKe.isEmpty()){
            for (int i =0; i<3; i++){
                listToArray(anKe,temp);
            }
        }
        if (!peng.isEmpty()){
            for (int i =0; i<3; i++){
                listToArray(peng,temp);
            }
        }
        for (int i = 0; i<temp.length;i++){
            if (temp[i] == 3)
                copyOfHand[i] -= 3;
        }

        for (int i =0; i<=6; i++){
            if (copyOfHand[i] >= 1 && copyOfHand[i+1] >= 1 && copyOfHand[i+2] >= 1 && copyOfHand[i+9] >= 1 && copyOfHand[i+10] >= 1 && copyOfHand[i+11] >= 1)  //万饼
                return true;
            else if (copyOfHand[i] >= 1 && copyOfHand[i+1] >= 1 && copyOfHand[i+2] >= 1 && copyOfHand[i+18] >= 1 && copyOfHand[i+19] >= 1 && copyOfHand[i+20] >= 1)  //万条
                return true;
        }
        for (int i =9; i<=15; i++){
            if (copyOfHand[i] >= 1 && copyOfHand[i+1] >= 1 && copyOfHand[i+2] >= 1 && copyOfHand[i+9] >= 1 && copyOfHand[i+10] >= 1 && copyOfHand[i+11] >= 1)  //饼条
                return true;
        }
        return false;
    }

    private boolean isYiBanGao(int[] hands) {
        if (fanXings.contains("YiSeShuangLongHui") || fanXings.contains("YiSeSiTongShun") || fanXings.contains("YiSeSanTongShun") || fanXings.contains("LianQiDui"))
            return false;
        for (int i =0; i<=6; i++){
            if (hands[i] == 2 && hands[i+1] == 2 && hands[i+2] == 2)
                return true;
        }
        for (int i =9; i<=15; i++){
            if (hands[i] == 2 && hands[i+1] == 2 && hands[i+2] == 2)
                return true;
        }
        for (int i =18; i<=24; i++){
            if (hands[i] == 2 && hands[i+1] == 2 && hands[i+2] == 2)
                return true;
        }
        return false;
    }

    private boolean isDuanYao(int[] hands) {
        //noWuZi
        if (fanXings.contains("QuanShuangKe") || fanXings.contains("QuanZhong") || fanXings.contains("QuanDaiWu"))
            return false;
        return hands[0] == 0 && hands[8] == 0 && hands[9] == 0 && hands[17] == 0 && hands[18] == 0 && isAllZero(hands,26,33);
    }

    private boolean isAnGang(int[] hands) {
        if (fanXings.contains("SiGang") || fanXings.contains("SanGang") || fanXings.contains("ShuangAnGang"))
            return false;
        return !anGang.isEmpty();
    }

    private boolean isShuangAnKe(int[] hands) {
        if (fanXings.contains("SiAnKe") || fanXings.contains("SanAnKe") || fanXings.contains("ShuangAnGang"))
            return false;
        return anKe.size() == 2;
    }

    private boolean isShuangTongKe(int[] hands) {
        if (fanXings.contains("SanTongKe"))
            return false;
        for (int i =0; i<9; i++){
            if ((hands[i] == 3 && hands[i+9] == 3)||(hands[i] == 3 && hands[i+18] == 3))
                return true;
        }
        for (int i =9; i<18; i++){
            if (hands[i] == 3 && hands[i+9] == 3)
                return true;
        }
        return false;
    }

    private boolean isSiGuiYi(int[] hands) {
        if (fanXings.contains("YiSeSiTongShun"))
            return false;
        if (!mingGang.isEmpty() || !anGang.isEmpty())
            return false;
        for (int i = 0; i<34; i++){
            if (hands[i] == 4)
                return true;
        }
        return false;
    }

    private boolean isPingHu(int[] hands) {
        // noWuZi
        if (fanXings.contains("YiSeShuangLongHui") || fanXings.contains("SanSeShuangLongHui") || fanXings.contains("LianQiDui"))
            return false;
        boolean pingHu = true;
        for (int i = 0; i<27; i++){
            if (hands[i] == 3)
                pingHu = false;
        }
        return pingHu && isAllZero(hands,27,33) ;
    }

    private boolean isMenQianQing(int[] hands) {
        if (fanXings.contains("JiuLianBaoDeng") || fanXings.contains("LianQiDui") || fanXings.contains("ShiSanYao") || fanXings.contains("SiAnKe") ||
                fanXings.contains("QiDui") || fanXings.contains("QiXingBuKao") || fanXings.contains("QuanBuKao") || fanXings.contains("BuQiuRen"))
            return false;
        return menQianQing;
    }

    private boolean isMenFengKe(int[] hands) {
        if (fanXings.contains("DaSiXi"))
            return false;
        //TODO Ask for user input
        return false;
    }

    private boolean isQuanFengKe(int[] hands) {
        if (fanXings.contains("DaSiXi") || fanXings.contains("XiaoSanYuan") || fanXings.contains("ShuangJianKe"))
            return false;
        //TODO Ask for user input
        return false;
    }

    private boolean isJianKe(int[] hands) {
        if (fanXings.contains("DaSanYuan") || fanXings.contains("XiaoSanYuan") || fanXings.contains("ShuangJianKe"))
            return false;
        for (int i = 31; i<34; i++){
            if (hands[i] == 3)
                return true;
        }
        return false;
    }

    private boolean isHuJueZhang(int[] hands) {
        if (fanXings.contains("QiangGangHu"))
            return false;
        //TODO Ask for user input
        return false;
    }

    private boolean isShuangMingGang(int[] hands) {
        //noMingGang
        if (fanXings.contains("SiGang") || fanXings.contains("SanGang"))
            return false;
        return mingGang.size() == 2;
    }

    private boolean isBuQiuRen(int[] hands) {
        //noMenQianQing, noZiMo
        if (fanXings.contains("JiuLianBaoDeng") || fanXings.contains("ShiSanYao") ||
            fanXings.contains("QiXingBuKao") || fanXings.contains("QuanBuKao"))
            return false;
        return ziMo && menQianQing;
    }

    private boolean isQuanDaiYao(int[] hands) {
        if (fanXings.contains("ShiSanYao") || fanXings.contains("QingYaoJiu") || fanXings.contains("ZiYiSe") || fanXings.contains("HunYaoJiu"))
            return false;
        //ToDo DO more research
        return false;
    }

    private boolean isShuangJianKe(int[] hands) {
        //noJianKe
        if (fanXings.contains("DaSanYuan") || fanXings.contains("XiaoSanYuan"))
            return false;
        int count = 0;
        for (int i = 31; i<34; i++){
            if (hands[i] == 3)
                count++;
        }
        return count == 2;
    }

    private boolean isShuangAnGang(int[] hands) {
        //noShuangJianKe
        if (fanXings.contains("SiGang") || fanXings.contains("SanGang"))
            return false;
        //TODO Get User Input
        return false;
    }

    private boolean isQuanQiuRen(int[] hands) {
        //noDanDiaoJiang
        //TODO Get User Input
        return false;
    }

    private boolean isWuMenQi(int[] hands) {
        if (fanXings.contains("QiXingBuKao") || fanXings.contains("ShiSanYao") || fanXings.contains("QuanBuKao"))
            return false;
        return !isAllZero(hands,0,8) && !isAllZero(hands,9,17) && !isAllZero(hands,18,26) && !isAllZero(hands,27,30) && !isAllZero(hands,31,33);
    }

    private boolean isHunYiSe(int[] hands) {
        //noQueYiMen
        if (!isAllZero(hands,27,33)){
            return (isAllZero(hands,9,26) && !isAllZero(hands,0,8)) || (isAllZero(hands,0,8) && isAllZero(hands,18,26) && !isAllZero(hands,9,17)) ||
                    (isAllZero(hands,0,17) && !isAllZero(hands,18,26));
        }
        return false;
    }

    private boolean isPengPengHu(int[] hands) {
        if (fanXings.contains("DaSiXi") || fanXings.contains("SiGang") || fanXings.contains("QingYaoJiu") || fanXings.contains("ZiYiSe") ||
                fanXings.contains("SiAnKe") || fanXings.contains("YiSeSiJieGao") || fanXings.contains("HunYaoJiu") || fanXings.contains("QuanShuangKe"))
            return false;
        int count = 0;
        for (int i =0; i< 34; i++){
            if (hands[i] >= 3)
                count++;
        }
        return count==4;
    }

    private boolean isQiangGangHu(int[] hands) {
        //noHujueZhang
        //TODO Get User Input
        return false;
    }

    private boolean isGangShangKaiHua(int[] hands) {
        //TODO Get User Input
        return false;
    }

    private boolean isHaiDiLaoYue(int[] hands) {
        //TODO Get User Input
        return false;
    }

    private boolean isWuFanHu(int[] hands) {
        Log.e("fx", fanXings.toString());
        return fanXings.isEmpty();
    }

    private boolean isTuiBuDao(int[] hands) {
        //noQueYiMen
        return (isAllZero(hands, 0,8) && isAllZero(hands, 14,15) && hands[18] == 0 && hands[20] == 0 && hands[24] == 0 && isAllZero(hands,27,32));
    }

    private boolean isHuaLong(int[] hands) {
        if (hands[0] >= 1 && hands[1] >= 1 && hands[2] >= 1){
            if (hands[12] >= 1 && hands[13] >= 1 && hands[14] >= 1 && hands[24] >= 1 && hands[25] >= 1 && hands[26] >= 1)  //万饼条
                return true;
            else if(hands[21] >= 1 && hands[22] >= 1 && hands[23] >= 1 && hands[15] >= 1 && hands[16] >= 1 && hands[17] >= 1) //万条饼
                return true;
        }else if (hands[9] >= 1 && hands[10] >= 1 && hands[11] >= 1){
            if (hands[3] >= 1 && hands[4] >= 1 && hands[5] >= 1 && hands[24] >= 1 && hands[25] >= 1 && hands[26] >= 1)  //饼万条
                return true;
            else if(hands[21] >= 1 && hands[22] >= 1 && hands[23] >= 1 && hands[6] >= 1 && hands[7] >= 1 && hands[8] >= 1) //饼条万
                return true;
        }else if (hands[18] >= 1 && hands[19] >= 1 && hands[20] >= 1){
            if (hands[3] >= 1 && hands[4] >= 1 && hands[5] >= 1 && hands[15] >= 1 && hands[16] >= 1 && hands[17] >= 1)  //条万饼
                return true;
            else if(hands[12] >= 1 && hands[13] >= 1 && hands[14] >= 1 && hands[6] >= 1 && hands[7] >= 1 && hands[8] >= 1) //条饼万
                return true;
        }
        return false;
    }

    private boolean isXiaoYuWu(int[] hands) {
        //noWuZi
        if (fanXings.contains("QuanXiao"))
            return false;
        return isAllZero(hands,4,8) && isAllZero(hands,13,17) && isAllZero(hands,22,33);
    }

    private boolean isDaYuWu(int[] hands) {
        //noWuZi
        if (fanXings.contains("QuanDa"))
            return false;
        return isAllZero(hands,0,4) && isAllZero(hands,9,13) && isAllZero(hands,18,22) && isAllZero(hands,27,33);
    }

    private boolean isSanAnKe(int[] hands) {
        //noShuangAnKe
        if (fanXings.contains("SiAnKe"))
            return false;
        if (anKe != null)
            return anKe.size() == 3;
        return false;
    }

    private boolean isSanTongKe(int[] hands) {
        //noShuangTongKe
        for (int i = 0; i < 9; i++){
            if (hands[i] == 3 && hands[i+9] == 3 && hands[i+18] == 3)
                return true;
        }
        return false;
    }

    private boolean isQuanDaiWu(int[] hands) {
        //TODO more research
        return false;
    }

    private boolean isQingYiSe(int[] hands) {
        //noQueYiMen, noWuZi
        if (fanXings.contains("JiuLianBaoDeng") || fanXings.contains("LianQiDui") || fanXings.contains("YiSeShuangLongHui"))
            return false;
        return sameTypeCards(hands, "w") == 14 || sameTypeCards(hands, "b") == 14 || sameTypeCards(hands, "t") == 14;
    }

    private boolean isQuanXiao(int[] hands) {
        //noWuZi, noXiaoYuWu
        return isAllZero(hands,3,8) && isAllZero(hands,12,17) && isAllZero(hands,21,33);
    }

    private boolean isSanSeSanBuGao(int[] hands) {
        for (int i =0 ;i<=2; i++){  //万开始
            if (hands[i] == 1 && hands[i+1] == 1 && hands[i+2] == 1 && hands[i+11] == 1 && hands[i+12] == 1 && hands[i+13] == 1 && hands[i+22]==3 && hands[i+23]==3 && hands[i+24]==3) //万<饼<条
                return true;
            else if(hands[i] == 1 && hands[i+1] == 1 && hands[i+2] == 1 && hands[i+20] == 1 && hands[i+21] == 1 && hands[i+22] == 1 && hands[i+13]==3 && hands[i+14]==3 && hands[i+15]==3) //万<条<饼
                return true;
        }
        for (int i =9 ;i<=11; i++){  //饼开始
            if (hands[i] == 3 && hands[i+10] == 3 && hands[i-7]==3) //饼<条<万
                return true;
            else if(hands[i] == 3 && hands[i-8] == 3 && hands[i+11]==3) //饼<万<条
                return true;
        }
        for (int i =18 ;i<=20; i++){  //条开始
            if (hands[i] == 3 && hands[i-17] == 3 && hands[i-7]==3) //条<万<饼
                return true;
            else if(hands[i] == 3 && hands[i-8] == 3 && hands[i-16]==3) //条<饼<万
                return true;
        }
        return false;
    }

    private boolean isSanSeSanJieGao(int[] hands) {
        for (int i =0 ;i<=6; i++){  //万开始
            if (hands[i] == 3 && hands[i+10] == 3 && hands[i+20]==3) //万<饼<条
                return true;
            else if(hands[i] == 3 && hands[i+19] == 3 && hands[i+11]==3) //万<条<饼
                return true;
        }
        for (int i =9 ;i<=15; i++){  //饼开始
            if (hands[i] == 3 && hands[i+10] == 3 && hands[i-7]==3) //饼<条<万
                return true;
            else if(hands[i] == 3 && hands[i-8] == 3 && hands[i+11]==3) //饼<万<条
                return true;
        }
        for (int i =18 ;i<=24; i++){  //条开始
            if (hands[i] == 3 && hands[i-17] == 3 && hands[i-7]==3) //条<万<饼
                return true;
            else if(hands[i] == 3 && hands[i-8] == 3 && hands[i-16]==3) //条<饼<万
                return true;
        }
        return false;
    }

    private boolean isSanSeSanTongShun(int[] hands) {
        // noXiXiangFeng
        for (int i = 0; i <=6; i++){
            if (hands[i] >= 1 && hands[i+1] >= 1 && hands[i+2] >= 1){
                if (hands[i+9] >= 1 && hands[i+10] >= 1 && hands[i+11] >= 1 && hands[i+18] >= 1 && hands[i+19] >= 1 && hands[i+20] >= 1)
                    return true;
            }
        }
        return false;
    }

    private boolean isSanFengKe(int[] hands) {
        //noQueYiMen
        if (fanXings.contains("XiaoSiXi") || fanXings.contains("DaSiXi"))
            return false;
        int count = 0;
        for (int i = 27; i <= 30; i++){
            if (hands[i] == 3)
                count++;
        }
        return count == 3;
    }

    private boolean isZuHeLong(int[] hands) {
        if (hands[0] >= 1 && hands[3] >= 1 && hands[6] >= 0){ //万147
            if (hands[10] >= 1 && hands[13] >= 1 && hands[16] >= 1){ //饼258
                return  hands[20] >= 1 && hands[23] >= 1 && hands[26] >= 1; //条369
            }else if(hands[11] >= 1 && hands[14] >= 1 && hands[17] >= 1){ //饼369
                return hands[19] >= 1 && hands[22] >= 1 && hands[25] >= 1; //条258
            }
        }else if (hands[1] >= 1 && hands[4] >= 1 && hands[7] >= 1){ //万258
            if (hands[9] >= 1 && hands[12] >= 1 && hands[15] >= 1) { //饼147
                return  hands[20] >= 1 && hands[23] >= 1 && hands[26] >= 1; //条369
            }else if(hands[11] >= 1 && hands[14] >= 1 && hands[17] >= 1) { //饼369
                return hands[18] >= 1 && hands[21] >= 1 && hands[24] >= 1; //条147
            }
        }else if (hands[2] >= 1 && hands[5] >= 1 && hands[8] >= 1){ //万369
            if (hands[9] >= 1 && hands[12] >= 1 && hands[15] >= 1){ //饼147
                return hands[19] >= 1 && hands[22] >= 1 && hands[25] >= 1; //条258
            }else if(hands[10] >= 1 && hands[13] >= 1 && hands[16] >= 1){ //饼258
                return hands[18] >= 1 && hands[21] >= 1 && hands[24] >= 1; //条147
            }
        }
        return false;
    }

    private boolean isQuanBuKao(int[] hands) {
        //todo buhu
        if (fanXings.contains("QiXingBuKao"))
            return false;
        if (hands[27] >= 1 && hands[28] >= 1 && hands[29] >= 1 && hands[30] >= 1 && hands[31] >= 1 && hands[32] >= 1 && hands[33] >= 1 && (hands[27] + hands[28] + hands[29] + hands[30] + hands[31] + hands[32] + hands[33] >= 5)){
            //check三种花色全有
            if (!isAllZero(hands,0,8) && !isAllZero(hands,9,17) && !isAllZero(hands,18,26)){
                //check只有147,258,369
                if (hands[1] == 0 && hands[2] == 0 && hands[4] == 0 && hands[5] == 0 && hands[7] == 0 && hands[8] == 0 && hands[0] <= 1 && hands[3] <= 1 && hands[6] <= 1){ //万147
                    if (hands[9] == 0 && hands[11] == 0 && hands[12] == 0 && hands[14] == 0 && hands[15] == 0 && hands[17] == 0 && hands[10] <= 1 && hands[13] <= 1 && hands[16] <= 1){ //饼258
                        return hands[18] == 0 && hands[19] == 0 && hands[21] == 0 && hands[22] == 0 && hands[24] == 0 && hands[25] == 0 && hands[20] <= 1 && hands[23] <= 1 && hands[26] <= 1; //条369

                    }else if(hands[9] == 0 && hands[10] == 0 && hands[12] == 0 && hands[13] == 0 && hands[15] == 0 && hands[16] == 0 && hands[11] <= 1 && hands[14] <= 1 && hands[17] <= 1){ //饼369
                        return hands[18] == 0 && hands[20] == 0 && hands[21] == 0 && hands[23] == 0 && hands[24] == 0 && hands[26] == 0 && hands[19] <= 1 && hands[22] <= 1 && hands[25] <= 1; //条258
                    }else
                        return false;
                }else if (hands[0] == 0 && hands[2] == 0 && hands[3] == 0 && hands[5] == 0 && hands[6] == 0 && hands[8] == 0 && hands[1] <= 1 && hands[4] <= 1 && hands[7] <= 1){ //万258
                    if (hands[10] == 0 && hands[11] == 0 && hands[13] == 0 && hands[14] == 0 && hands[16] == 0 && hands[17] == 0 && hands[9] <= 1 && hands[12] <= 1 && hands[15] <= 1) { //饼147
                        return hands[18] == 0 && hands[19] == 0 && hands[21] == 0 && hands[22] == 0 && hands[24] == 0 && hands[25] == 0 && hands[20] <= 1 && hands[23] <= 1 && hands[26] <= 1; //条369

                    }else if(hands[9] == 0 && hands[10] == 0 && hands[12] == 0 && hands[13] == 0 && hands[15] == 0 && hands[16] == 0 && hands[11] <= 1 && hands[14] <= 1 && hands[17] <= 1) { //饼369
                        return hands[19] == 0 && hands[20] == 0 && hands[22] == 0 && hands[23] == 0 && hands[25] == 0 && hands[26] == 0 && hands[18] <= 1 && hands[21] <= 1 && hands[24] <= 1; //条147
                    }
                }else if (hands[0] == 0 && hands[1] == 0 && hands[3] == 0 && hands[4] == 0 && hands[6] == 0 && hands[7] == 0 && hands[2] <= 1 && hands[5] <= 1 && hands[8] <= 1){ //万369
                    if (hands[10] == 0 && hands[11] == 0 && hands[13] == 0 && hands[14] == 0 && hands[16] == 0 && hands[17] == 0 && hands[9] <= 1 && hands[12] <= 1 && hands[15] <= 1){ //饼147
                        return hands[18] == 0 && hands[20] == 0 && hands[21] == 0 && hands[23] == 0 && hands[24] == 0 && hands[26] == 0 && hands[19] <= 1 && hands[22] <= 1 && hands[25] <= 1; //条258

                    }else if(hands[9] == 0 && hands[11] == 0 && hands[12] == 0 && hands[14] == 0 && hands[15] == 0 && hands[17] == 0 && hands[10] <= 1 && hands[13] <= 1 && hands[16] <= 1){ //饼258
                        return hands[19] == 0 && hands[20] == 0 && hands[22] == 0 && hands[23] == 0 && hands[25] == 0 && hands[26] == 0 && hands[18] <= 1 && hands[21] <= 1 && hands[24] <= 1; //条147
                    }
                }else
                    return false;
            }
            else
                return false;
        }
        return false;
    }

    private boolean isYiSeSanBuGao(int[] hands) {
        if (fanXings.contains("YiSeSiBuGao"))
            return false;
        int start = -1;
        int end = -1;
        // check一种花色12张
        if (sameTypeCards(hands, "w") >= 9){  //万
            if (hands[0] != 0)
                start = 0;
            if (hands[8] != 0)
                end = 8;
            for (int i=1; i< 8 ; i++){
                if (hands[i - 1] == 0 && hands[i] != 0)
                    if (start != -1)
                        start = i;
                if (hands[i] != 0 && hands[i + 1] == 0)
                    if (end != -1)
                        end = i;
            }
        }else if(sameTypeCards(hands, "b") >= 9){  //饼
            if (hands[9] != 0)
                start = 9;
            if (hands[17] != 0)
                end = 17;
            for (int i=10; i< 17 ; i++){
                if (hands[i - 1] == 0 && hands[i] != 0)
                    if (start != -1)
                        start = i;
                if (hands[i] != 0 && hands[i + 1] == 0)
                    if (end != -1)
                        end = i;
            }
        }else if(sameTypeCards(hands, "t") >= 9){  //条
            if (hands[18] != 0)
                start = 18;
            if (hands[26] != 0)
                end = 26;
            for (int i=19; i< 26 ; i++){
                if (hands[i - 1] == 0 && hands[i] != 0)
                    if (start != -1)
                        start = i;
                if (hands[i] != 0 && hands[i + 1] == 0)
                    if (end != -1)
                        end = i;
            }
        }else
            return false;
        if (start <= end-6) {
            //两张递增
            for (int i = start; i<=end-6; i++){
                if (hands[i] == 1 && hands[i+1] == 1 && hands[i+2] == 2 && hands[i+3] == 1 && hands[i+4] == 1 && hands[i+5] == 1 && hands[i+6] == 1)
                    return true;
            }
            //一张递增
            for (int i = start; i<=end-4; i++){
                if (hands[i] == 1 && hands[i+1] == 2 && hands[i+2] == 3 && hands[i+4] == 2 && hands[i+4] == 1)
                    return true;
            }
        }
        return false;
    }

    private boolean isSanSeShuangLongHui(int[] hands) {
        // noXiXiangFeng, noLaoShaoFu, noWuZi, noPinghu
        if (isAllZero(hands, 27,33)){
            if (hands[0] == 1 && hands[1] == 1 && hands[2] == 1 && hands[6] == 1 && hands[7] == 1 && hands[8] == 1){   //万
                if (hands[9] == 1 && hands[10] == 1 && hands[11] == 1 && hands[15] == 1 && hands[16] == 1 && hands[17] == 1 && hands[22] == 2)   //饼条
                    return true;
                else return (hands[18] == 1 && hands[19] == 1 && hands[20] == 1 && hands[24] == 1 && hands[25] == 1 && hands[26] == 1 && hands[13] == 2); //条饼
            }else if(hands[9] == 1 && hands[10] == 1 && hands[11] == 1 && hands[15] == 1 && hands[16] == 1 && hands[17] == 1){  //饼
                return (hands[18] == 1 && hands[19] == 1 && hands[20] == 1 && hands[24] == 1 && hands[25] == 1 && hands[26] == 1 && hands[4] == 2); //条万
            }
        }
        return false;
    }

    private boolean isQingLong(int[] hands) {
        //noLianLiu, noLaoShaoFu
        if (sameTypeCards(hands, "w") >= 9){  //万
            boolean allOne = true;
            for (int i = 0; i < 9 ; i++){
                if(hands[i] < 1)
                    allOne = false;
            }
            return allOne;
        }else if(sameTypeCards(hands, "b") >= 9){  //饼
            boolean allOne = true;
            for (int i = 9; i < 18; i++){
                if(hands[i] < 1)
                    allOne = false;
            }
            return allOne;
        }else if(sameTypeCards(hands, "t") >= 9){  //条
            boolean allOne = true;
            for (int i = 18; i < 27; i++){
                if(hands[i] < 1)
                    allOne = false;
            }
            return allOne;
        }
        return false;
    }

    private boolean isQuanZhong(int[] hands) {
        //noDuanYao, noWuZi
        return isAllZero(hands,0,2) && isAllZero(hands,6,8) && isAllZero(hands,9,11) && isAllZero(hands, 15,17) &&
                isAllZero(hands,18,20) && isAllZero(hands,24,26) && isAllZero(hands, 27,33);
    }

    private boolean isQuanDa(int[] hands) {
        //NoWuZi, noDaYuWu
        return isAllZero(hands,0,5) && isAllZero(hands,9,14) && isAllZero(hands,18,23) && isAllZero(hands, 27,33);
    }

    private boolean isYiSeSanJieGao(int[] hands) {
        // noYiSeSanTongShun
        if (fanXings.contains("YiSeSiTongShun") || fanXings.contains("YiSeSiJieGao") || fanXings.contains("YiSeSanTongShun")){
            return false;
        }
        if (sameTypeCards(hands, "w") >= 9){  //万
            for (int i = 0; i <= 6; i++){
                if (hands[i] == 3 && hands[i + 1] == 3 && hands[i + 2] == 3)
                    return true;
            }
        }else if(sameTypeCards(hands, "b") >= 9){  //饼
            for (int i = 9; i <= 15; i++){
                if (hands[i] == 3 && hands[i + 1] == 3 && hands[i + 2] == 3)
                    return true;
            }
        }else if(sameTypeCards(hands, "t") >= 9){  //条
            for (int i = 18; i <= 24; i++){
                if (hands[i] == 3 && hands[i + 1] == 3 && hands[i + 2] == 3)
                    return true;
            }
        }
        return false;
    }

    private boolean isYiSeSanTongShun(int[] hands) {
        // noYiSeSanJieGao, noYiBanGao
        if (fanXings.contains("YiSeSiTongShun") || fanXings.contains("YiSeSiJieGao") || fanXings.contains("YiSeSanJieGao"))
            return false;
        if (sameTypeCards(hands, "w") >= 9){  //万
            for (int i = 0; i <= 6; i++){
                if (hands[i] == 3 && hands[i + 1] == 3 && hands[i + 2] == 3)
                    return true;
            }
        }else if(sameTypeCards(hands, "b") >= 9){  //饼
            for (int i = 9; i <= 15; i++){
                if (hands[i] == 3 && hands[i + 1] == 3 && hands[i + 2] == 3)
                    return true;
            }
        }else if(sameTypeCards(hands, "t") >= 9){  //条
            for (int i = 18; i <= 24; i++){
                if (hands[i] == 3 && hands[i + 1] == 3 && hands[i + 2] == 3)
                    return true;
            }
        }
        return false;
    }

    private boolean isQuanShuangKe(int[] hands) {
        //noPengPengHu, noDuanYao, noWuZi
        //check 除了[2][4][6][8]其余位置都为0
        return hands[0] == 0 && hands[2] == 0 && hands[4] == 0 && hands[6] == 0 && hands[8] == 0 && hands[9] == 0 && hands[11] == 0 && hands[13] == 0 && hands[15] == 0 && hands[17] == 0 &&
                hands[18] == 0 && hands[20] == 0 && hands[22] == 0 && hands[24] == 0 && isAllZero(hands,26,33);
    }

    private boolean isQiXingBuKao(int[] hands) {
        // noWuMenQi, noBuQiuRen, noDanDiaoJiang, noMenQianQing, noQuanBuKao
        //check字牌
        if (hands[27] == 1 && hands[28] == 1 && hands[29] == 1 && hands[30] == 1 && hands[31] == 1 && hands[32] == 1 && hands[33] == 1){
            //check三种花色全有
            if (!isAllZero(hands,0,8) && !isAllZero(hands,9,17) && !isAllZero(hands,18,26)){
                //check只有147,258,369
                if (hands[1] == 0 && hands[2] == 0 && hands[4] == 0 && hands[5] == 0 && hands[7] == 0 && hands[8] == 0 && hands[0] <= 1 && hands[3] <= 1 && hands[6] <= 1){ //万147
                    if (hands[9] == 0 && hands[11] == 0 && hands[12] == 0 && hands[14] == 0 && hands[15] == 0 && hands[17] == 0 && hands[10] <= 1 && hands[13] <= 1 && hands[16] <= 1){ //饼258
                        return hands[18] == 0 && hands[19] == 0 && hands[21] == 0 && hands[22] == 0 && hands[24] == 0 && hands[25] == 0 && hands[20] <= 1 && hands[23] <= 1 && hands[26] <= 1; //条369

                    }else if(hands[9] == 0 && hands[10] == 0 && hands[12] == 0 && hands[13] == 0 && hands[15] == 0 && hands[16] == 0 && hands[11] <= 1 && hands[14] <= 1 && hands[17] <= 1){ //饼369
                        return hands[18] == 0 && hands[20] == 0 && hands[21] == 0 && hands[23] == 0 && hands[24] == 0 && hands[26] == 0 && hands[19] <= 1 && hands[22] <= 1 && hands[25] <= 1; //条258
                    }else
                        return false;
                }else if (hands[0] == 0 && hands[2] == 0 && hands[3] == 0 && hands[5] == 0 && hands[6] == 0 && hands[8] == 0 && hands[1] <= 1 && hands[4] <= 1 && hands[7] <= 1){ //万258
                    if (hands[10] == 0 && hands[11] == 0 && hands[13] == 0 && hands[14] == 0 && hands[16] == 0 && hands[17] == 0 && hands[9] <= 1 && hands[12] <= 1 && hands[15] <= 1) { //饼147
                        return hands[18] == 0 && hands[19] == 0 && hands[21] == 0 && hands[22] == 0 && hands[24] == 0 && hands[25] == 0 && hands[20] <= 1 && hands[23] <= 1 && hands[26] <= 1; //条369

                    }else if(hands[9] == 0 && hands[10] == 0 && hands[12] == 0 && hands[13] == 0 && hands[15] == 0 && hands[16] == 0 && hands[11] <= 1 && hands[14] <= 1 && hands[17] <= 1) { //饼369
                        return hands[19] == 0 && hands[20] == 0 && hands[22] == 0 && hands[23] == 0 && hands[25] == 0 && hands[26] == 0 && hands[18] <= 1 && hands[21] <= 1 && hands[24] <= 1; //条147
                    }
                }else if (hands[0] == 0 && hands[1] == 0 && hands[3] == 0 && hands[4] == 0 && hands[6] == 0 && hands[7] == 0 && hands[2] <= 1 && hands[5] <= 1 && hands[8] <= 1){ //万369
                    if (hands[10] == 0 && hands[11] == 0 && hands[13] == 0 && hands[14] == 0 && hands[16] == 0 && hands[17] == 0 && hands[9] <= 1 && hands[12] <= 1 && hands[15] <= 1){ //饼147
                        return hands[18] == 0 && hands[20] == 0 && hands[21] == 0 && hands[23] == 0 && hands[24] == 0 && hands[26] == 0 && hands[19] <= 1 && hands[22] <= 1 && hands[25] <= 1; //条258

                    }else if(hands[9] == 0 && hands[11] == 0 && hands[12] == 0 && hands[14] == 0 && hands[15] == 0 && hands[17] == 0 && hands[10] <= 1 && hands[13] <= 1 && hands[16] <= 1){ //饼258
                        return hands[19] == 0 && hands[20] == 0 && hands[22] == 0 && hands[23] == 0 && hands[25] == 0 && hands[26] == 0 && hands[18] <= 1 && hands[21] <= 1 && hands[24] <= 1; //条147
                    }
                }else
                    return false;
            }
            else
                return false;
        }
        return false;
    }

    private boolean isQiDui(int[] hands) {
        //TODO buhu
        // noMenQianQing, noBuQiuRen, noDanDiao
        if (fanXings.contains("LianQiDui") || fanXings.contains("YiSeShuangLongHui"))
            return false;
        int count = 0;
        for (int i= 0; i < hands.length; i++){
            if (hands[i] == 2)
                count++;
        }
        return count == 7;
    }

    private boolean isHunYaoJiu(int[] hands) {
        // noPengPengHu, noYaoJiuKe, noQuanDaiYao
        if (fanXings.contains("ZiYiSe") || fanXings.contains("QingYaoJiu"))
            return false;
        return isAllZero(hands,1,7) && isAllZero(hands, 10, 16) && isAllZero(hands, 19, 25);
    }

    private boolean isSanGang(int[] hands) {
        //noShuangAnGang, noShuangMingGang, noAnGang, noMingGang, noMingAnGang
        if (fanXings.contains("SiGang") || fanXings.contains("YiSeSiTongShun"))
            return false;
        int count = 0;
        for (int i= 0; i < hands.length; i++){
            if (hands[i] == 4)
                count++;
        }
        return count == 3;
    }

    private boolean isYiSeSiBuGao(int[] hands) {
        // noYiSeSanBuGao, noQueYiMen
        int start = -1;
        int end = -1;
        // check一种花色12张
        if (sameTypeCards(hands, "w") == 12){  //万
            if (hands[0] != 0)
                start = 0;
            if (hands[8] != 0)
                end = 8;
            for (int i=1; i< 8 ; i++){
                if (hands[i - 1] == 0 && hands[i] != 0)
                    if (start != -1)
                        start = i;
                if (hands[i] != 0 && hands[i + 1] == 0)
                    if (end != -1)
                        end = i;
            }
        }else if(sameTypeCards(hands, "b") == 12){  //饼
            if (hands[9] != 0)
                start = 9;
            if (hands[17] != 0)
                end = 17;
            for (int i=10; i< 17 ; i++){
                if (hands[i - 1] == 0 && hands[i] != 0)
                    if (start != -1)
                        start = i;
                if (hands[i] != 0 && hands[i + 1] == 0)
                    if (end != -1)
                        end = i;
            }
        }else if(sameTypeCards(hands, "t") == 12){  //条
            if (hands[18] != 0)
                start = 18;
            if (hands[26] != 0)
                end = 26;
            for (int i=19; i< 26 ; i++){
                if (hands[i - 1] == 0 && hands[i] != 0)
                    if (start != -1)
                        start = i;
                if (hands[i] != 0 && hands[i + 1] == 0)
                    if (end != -1)
                        end = i;
            }
        }else
            return false;
        //check中间张
        if (start < end){
            //两张递增
            if ((start == 0 && end == 8) || (start == 9 && end == 17) || (start == 18 && end == 26)){
                if (hands[start] == 1 && hands[start + 1] == 1 && hands[start + 2] == 2 && hands[start + 3] == 1 && hands[start + 4] == 2
                        && hands[start + 5] == 1 && hands[start + 6] == 2 && hands[start + 7] == 1 && hands[start + 8] == 1)
                    return true;
            }else if (hands[start] == 1 && hands[end] == 1){    //一张递增
                boolean allTwo = true;
                for (int i = start + 1; i < end; i++ ){
                    if (hands[i] != 2)
                        allTwo = false;
                }
                return allTwo;
            }else
                return false;
        }
        return false;
    }

    private boolean isYiSeSiJieGao(int[] hands) {
        // noYiSeSanTongShun, noYiSeSanJieGao, noPengPengHu, noQueYiMen
        if (sameTypeCards(hands, "w") >= 12){  //万
            for (int i = 0; i <= 5; i++){
                if (hands[i] == 3 && hands[i + 1] == 3 && hands[i + 2] == 3 && hands[i + 3] == 3)
                    return true;
            }
        }else if(sameTypeCards(hands, "b") >= 12){  //饼
            for (int i = 9; i <= 14; i++){
                if (hands[i] == 3 && hands[i + 1] == 3 && hands[i + 2] == 3 && hands[i + 3] == 3)
                    return true;
            }
        }else if(sameTypeCards(hands, "t") >= 12){  //条
            for (int i = 18; i <= 23; i++){
                if (hands[i] == 3 && hands[i + 1] == 3 && hands[i + 2] == 3 && hands[i + 3] == 3)
                    return true;
            }
        }
        return false;
    }

    private boolean isYiSeSiTongShun(int[] hands) {
        // noYiSeSanJieGao, noYiBanGao, noSiGuiYi, noYiSeSanTongShun, noQueYiMen
        if (sameTypeCards(hands, "w") >= 12){  //万
            for (int i = 0; i <= 6; i++){
                if (hands[i] == 4 && hands[i + 1] == 4 && hands[i + 2] == 4)
                    return true;
            }
        }else if(sameTypeCards(hands, "b") >= 12){  //饼
            for (int i = 9; i <= 15; i++){
                if (hands[i] == 4 && hands[i + 1] == 4 && hands[i + 2] == 4)
                    return true;
            }
        }else if(sameTypeCards(hands, "t") >= 12){  //条
            for (int i = 18; i <= 24; i++){
                if (hands[i] == 4 && hands[i + 1] == 4 && hands[i + 2] == 4)
                    return true;
            }
        }
        return false;
    }

    private boolean isYiSeShuangLongHui(int[] hands) {
        // noPingHu, noQiDui, noQingYiSe, noYiBanGao, noLaoShaoFu, noQueYiMen, noWuZi
        return  (hands[0] == 2 && hands[1] == 2 && hands[2] == 2 && hands[4] == 2 && hands[6] == 2 && hands[7] == 2 && hands[8] == 2) ||
                (hands[9] == 2 && hands[10] == 2 && hands[11] == 2 && hands[13] == 2 && hands[15] == 2 && hands[16] == 2 && hands[17] == 2) ||
                (hands[18] == 2 && hands[19] == 2 && hands[20] == 2 && hands[22] == 2 && hands[24] == 2 && hands[25] == 2 && hands[27] == 2);
    }

    private boolean isSiAnKe(int[] hands) {
        // noMenQianQing, noPengPengHu, noSanAnKe, noShuangAnKe, noBuQiuRen
        if (anKe != null)
            return anKe.size() == 4;
        return false;
    }

    private boolean isZiYiSe(int[] hands) {
        // noPengPengHu, noHunYaoJiu, noQuanDaiYao, noYaoJiuKe, noQueYiMen
        return isAllZero(hands, 0, 26);
    }

    private boolean isXiaoSanYuan(int[] hands) {
        //noShuangJianKe, noJianKe, noQueYiMen
        int count = 0;
        for (int i=31;i<=33; i++){
            if (hands[i] == 3)
                count++;
        }
        return count == 2 && (hands[31] + hands[32] + hands[33]) == 8;
    }

    private boolean isXiaoSiXi(int[] hands) {
        //noSanFengKe, noQueYiMen,  noYaoJiuKe
        int count = 0;
        for (int i=27;i<=30; i++){
            if (hands[i] == 3)
                count++;
        }
        return count == 3 && (hands[27] + hands[28] + hands[29] + hands[30]) == 11;
    }

    private boolean isQingYaoJiu(int[] hands) {
        //noPengPengHu, noShuangTongKe, noWuZi, noHunYaoJiu, noQuanDaiYao, noYaoJiuKe
        return isAllZero(hands, 1,7) && isAllZero(hands,10,16) && isAllZero(hands,19,25) && isAllZero(hands, 27,33);
    }

    private boolean isShiSanYao(int[] hands) {
        //noWuMenQi, noBuQiuRen, noDanDiaoJiang, noMenQianQing, noQuanDaoYao
        // TODO bu hu
        return hands[0] >= 1 && hands[8] >= 1 && hands[9] >= 1 && hands[17] >= 1 && hands[18] >= 1 && hands[26] >= 1 &&
                hands[27] >= 1 && hands[28] >= 1 && hands[29] >= 1 && hands[30] >= 1 && hands[31] >= 1 && hands[32] >= 1 && hands[33] >= 1 &&
                isAllZero(hands,1,7) && isAllZero(hands,10,16) && isAllZero(hands,19,25);
    }

    private boolean isLianQiDui(int[] hands) {
        //noQingYiSe, noBuQiuRen, noDanDiaoJiang, noMenQianQing, noQiDui,noQiuYiMen, noWuZi
        int count = 0;
        for (int i=0; i<9; i++){
            if (count == 7)
                return true;
            if (hands[i] == 2)
                count++;
            else
                count = 0;
        }
        if (count == 7)
            return true;
        else {
            count = 0;
            for (int i=9; i<18; i++){
                if (count == 7)
                    return true;
                if (hands[i] == 2)
                    count++;
                else
                    count = 0;
            }
            if (count == 7)
                return true;
            else {
                count = 0;
                for (int i=18; i<27; i++){
                    if (count == 7)
                        return true;
                    if (hands[i] == 2)
                        count++;
                    else
                        count = 0;
                }
                return count == 7;
            }
        }
    }

    private boolean isSiGang(int[] hands) {
        //TODO bu hu
        //noSanGang, noShuangAnGang, noShuangMingGang,noMingGang,noAnGang,noDanDiaoJiang,noPengPengHu
        int count = 0;
        for (int i= 0; i < hands.length; i++){
            if (hands[i] == 4)
                count++;
        }
        return count == 4;
    }

    private boolean isJiuLianBaoDeng(int[] hands) {
        //noQingYiSe, noMenQianQing, noYaoJiuKe, noBuQiuRen
        if (hands[0] >= 3 && hands[1] >= 1 && hands[2] >= 1 && hands[3] >= 1 && hands[4] >= 1 && hands[5] >= 1 && hands[6] >= 1 && hands[7] >= 1 && hands[8] >= 3 && isAllZero(hands, 9, 33))
            return true;
        else if(hands[9] >= 3 && hands[10] >= 1 && hands[11] >= 1 && hands[12] >= 1 && hands[13] >= 1 && hands[14] >= 1 && hands[15] >= 1 && hands[16] >= 1 && hands[17] >= 3 && isAllZero(hands, 0, 8) && isAllZero(hands, 18, 33))
            return true;
        else if(hands[18] >= 3 && hands[19] >= 1 && hands[20] >= 1 && hands[21] >= 1 && hands[22] >= 1 && hands[23] >= 1 && hands[24] >= 1 && hands[25] >= 1 && hands[26] >= 3 && isAllZero(hands, 0, 17) && isAllZero(hands, 27, 33))
            return true;
        else
            return false;
    }

    private boolean isLvYiSe(int[] hands) {
        //noHunYiSe
        return hands[10] + hands[11] + hands[12] + hands[14] + hands[16] + hands[32] == 14;
    }

    private boolean isDaSanYuan(int[] hands) {
        //noJianKy, noShuangJianKe
        return hands[31] >= 3 && hands[32] >= 3 && hands[33] >= 3;
    }

    private boolean isDaSiXi(int[] hands) {
        //noQuanFengKe, noMenFeng,noSanFeng,noYaoJiu,noPengPeng

        return  (hands[27] >= 3 && hands[28] >= 3 && hands[29] >= 3 && hands[30] >= 3);
    }

    private boolean isAllZero(int[] list, int start, int end){
        boolean allZero = true;
        for (int i = start; i <= end; i++){
            if (list[i] != 0)
                allZero = false;
        }
        return allZero;
    }

    private int sameTypeCards(int[] list, String type){
        int count = 0;
        if (type.equals("w")){
            for (int i = 0; i < 9; i++){
                count += list[i];
            }
        }else if (type.equals("b")){
            for (int i = 9; i < 18; i++){
                count += list[i];
            }
        }else if (type.equals("t")){
            for (int i = 18; i < 27; i++){
                count += list[i];
            }
        }else if (type.equals("z")){
            for (int i = 27; i < 34; i++){
                count += list[i];
            }
        }
        return count;
    }

}
