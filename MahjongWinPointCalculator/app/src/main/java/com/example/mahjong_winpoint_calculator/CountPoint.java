package com.example.mahjong_winpoint_calculator;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;


public class CountPoint {
    private int basePoint;
    private int finalPoint;
    private int[] hands;

    private static final String TAG = "CountPointClass";

    private ArrayList<String> fanXings;



    public CountPoint(int basePoint, ArrayList<String> hands){
        this.hands = new int[34];
        Arrays.fill(this.hands, 0);
        this.basePoint = basePoint;
        this.hands = listToArray(hands);
        this.fanXings = new ArrayList<>();
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
                this.hands[32] = this.hands[32] + 1;
            }else if (card.endsWith("B")){
                this.hands[33] = this.hands[33] + 1;
            }
        }

        return hands;
    }

    public void calculate_final_point(){
        ArrayList<String> paiXingResult = new ArrayList<>();
        if (isDaSiXi(hands)){
            fanXings.add("DaSiXi");
            paiXingResult.add("大四喜");
        }else if(isDaSanYuan(hands)){
            fanXings.add("DaSanYuan");
            paiXingResult.add("大三元");
        }else if(isLvYiSe(hands)){
            fanXings.add("LvYiSe");
            paiXingResult.add("绿一色");
        }else if(isJiuLianBaoDeng(hands)){
            fanXings.add("JiuLianBaoDeng");
            paiXingResult.add("九莲宝灯");
        }else if(isSiGang(hands)){
            fanXings.add("SiGang");
            paiXingResult.add("四杠");
        }else if(isLianQiDui(hands)){
            fanXings.add("LianQiDui");
            paiXingResult.add("连七对");
        }else if(isShiSanYao(hands)){
            fanXings.add("ShiSanYao");
            paiXingResult.add("十三幺");
        }else if(isQingYaoJiu(hands)){
            fanXings.add("QingYaoJiu");
            paiXingResult.add("清幺九");
        }else if(isXiaoSiXi(hands)){
            fanXings.add("XiaoSiXi");
            paiXingResult.add("小四喜");
        }else if(isXiaoSanYuan(hands)){
            fanXings.add("XiaoSanYuan");
            paiXingResult.add("小三元");
        }else if(isZiYiSe(hands)){
            fanXings.add("ZiYiSe");
            paiXingResult.add("字一色");
        }else if(isSiAnKe(hands)){
            fanXings.add("SiAnKe");
            paiXingResult.add("四暗刻");
        }else if(isYiSeShuangLongHui(hands)){
            fanXings.add("YiSeShuangLongHui");
            paiXingResult.add("一色双龙会");
        }else if(isYiSeSiTongShun(hands)){
            fanXings.add("YiSeSiTongShun");
            paiXingResult.add("一色四同顺");
        }else if(isYiSeSiJieGao(hands)){
            fanXings.add("YiSeSiJieGao");
            paiXingResult.add("一色四节高");
        }else if(isYiSeSiBuGao(hands)){
            fanXings.add("YiSeSiBuGao");
            paiXingResult.add("一色四步高");
        }else if(isSanGang(hands)){
            fanXings.add("SanGang");
            paiXingResult.add("三杠");
        }else if(isHunYaoJiu(hands)){
            fanXings.add("HunYaoJiu");
            paiXingResult.add("混幺九");
        }else if(isQiDui(hands)){
            fanXings.add("QiDui");
            paiXingResult.add("七对");
        }else if(isQiXingBuKao(hands)){
            fanXings.add("QiXingBuKao");
            paiXingResult.add("七星不靠");
        }else if(isQuanShuangKe(hands)){
            fanXings.add("QuanShuangKe");
            paiXingResult.add("全双刻");
        }else if(isYiSeSanTongShun(hands)){
            fanXings.add("YiSeSanTongShun");
            paiXingResult.add("一色三同顺");
        }else if(isYiSeSanJieGao(hands)){
            fanXings.add("YiSeSanJieGao");
            paiXingResult.add("一色三节高");
        }else if(isQuanDa(hands)){
            fanXings.add("QuanDa");
            paiXingResult.add("全大");
        }else if(isQuanZhong(hands)){
            fanXings.add("QuanZhong");
            paiXingResult.add("全中");
        }else if(isQingLong(hands)){
            fanXings.add("QingLong");
            paiXingResult.add("清龙");
        }else if(isSanSeShuangLongHui(hands)){
            fanXings.add("SanSeShuangLongHui");
            paiXingResult.add("三色双龙会");
        }else if(isYiSeSanBuGao(hands)){
            fanXings.add("YiSeSanBuGao");
            paiXingResult.add("一色三步高");
        }else if(isQuanBuKao(hands)){
            fanXings.add("QuanBuKao");
            paiXingResult.add("全不靠");
        }else if(isZuHeLong(hands)){
            fanXings.add("ZuHeLong");
            paiXingResult.add("组合龙");
        }else if(isSanFengKe(hands)){
            fanXings.add("SanFengKe");
            paiXingResult.add("三风刻");
        }else if(isSanSeSanTongShun(hands)){
            fanXings.add("SanSeSanTongShun");
            paiXingResult.add("三色三同顺");
        }else if(isSanSeSanJieGao(hands)){
            fanXings.add("SanSeSanJieGao");
            paiXingResult.add("三色三节高");
        }else if(isSanSeSanBuGao(hands)){
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
    }

    private boolean isMenQianQing(int[] hands) {
        if (fanXings.contains("JiuBaoLianDeng") || fanXings.contains("LianQiDui") || fanXings.contains("ShiSanYao") || fanXings.contains("SiAnKe") ||
                fanXings.contains("QiDui") || fanXings.contains("QiXingBuKao") || fanXings.contains("QuanBuKao") || fanXings.contains("BuQiuRen"))
            return false;
        //TODO Ask for user input
        return false;
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
        //TODO Ask for user input
        return false;
    }

    private boolean isBuQiuRen(int[] hands) {
        //noMenQianQing, noZiMo
        if (fanXings.contains("JiuBaoLianDeng") || fanXings.contains("LianQiDui") || fanXings.contains("ShiSanYao") || fanXings.contains("SiAnKe") ||
                fanXings.contains("QiDui") || fanXings.contains("QiXingBuKao") || fanXings.contains("QuanBuKao"))
            return false;
        //TODO Ask for user input
        return false;
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
        if (fanXings.contains("LvYiSe"))
            return false;
        return  (isAllZero(hands,9,26) || (isAllZero(hands,0,8) && isAllZero(hands,18,26)) || isAllZero(hands,0,17));
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
        return fanXings.isEmpty();
    }

    private boolean isTuiBuDao(int[] hands) {
        //noQueYiMen
        return (isAllZero(hands, 0,8) && hands[18] == 0 && hands[20] == 0 && hands[24] == 0 && isAllZero(hands,27,32));
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
        //Todo ask user
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
        if (fanXings.contains("JiuBaoLianDeng") || fanXings.contains("LianQiDui") || fanXings.contains("YiSeShuangLongHui"))
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
        for (int i = 27; i < 34; i++){
            if (hands[i] == 3)
                count++;
        }
        return count == 3;
    }

    private boolean isZuHeLong(int[] hands) {
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
        }
        return false;
    }

    private boolean isQuanBuKao(int[] hands) {
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
                else return (hands[18] == 1 && hands[19] == 1 && hands[20] == 1 && hands[24] == 1 && hands[25] == 1 && hands[126] == 1 && hands[13] == 2); //条饼
            }else if(hands[9] == 1 && hands[10] == 1 && hands[11] == 1 && hands[15] == 1 && hands[16] == 1 && hands[17] == 1){  //饼
                return (hands[18] == 1 && hands[19] == 1 && hands[20] == 1 && hands[24] == 1 && hands[25] == 1 && hands[126] == 1 && hands[4] == 2); //条万
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
        // noMenQianQing, noBuQiuRen, noDanDiao
        if (fanXings.contains("LianQiDui"))
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
        if (fanXings.contains("SiGang"))
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
        // TODO get user input
        return false;
    }

    private boolean isZiYiSe(int[] hands) {
        // noPengPengHu, noHunYaoJiu, noQuanDaiYao, noYaoJiuKe, noQueYiMen
        return isAllZero(hands, 0, 26);
    }

    private boolean isXiaoSanYuan(int[] hands) {
        //noShuangJianKe, noJianKe, noQueYiMen
        return hands[31] >= 2 && hands[32] >= 2 && hands[33] >= 2 && (hands[31] + hands[32] + hands[33]) >= 8;
    }

    private boolean isXiaoSiXi(int[] hands) {
        //noSanFengKe, noQueYiMen,  noYaoJiuKe
        return hands[27] >= 2 && hands[28] >= 2 && hands[29] >= 2 && hands[30] >= 2 && (hands[27] + hands[28] + hands[29] + hands[30]) >= 11;
    }

    private boolean isQingYaoJiu(int[] hands) {
        //noPengPengHu, noShuangTongKe, noWuZi, noHunYaoJiu, noQuanDaiYao, noYaoJiuKe
        return isAllZero(hands, 1,7) && isAllZero(hands,10,16) && isAllZero(hands,19,25) && isAllZero(hands, 27,33);
    }

    private boolean isShiSanYao(int[] hands) {
        //noWuMenQi, noBuQiuRen, noDanDiaoJiang, noMenQianQing, noQuanDaoYao
        return hands[0] >= 1 && hands[8] >= 1 && hands[9] >= 1 && hands[17] >= 1 && hands[18] >= 1 && hands[26] >= 1 &&
                hands[27] >= 1 && hands[28] >= 1 && hands[29] >= 1 && hands[30] >= 1 && hands[31] >= 1 && hands[32] >= 1 && hands[33] >= 1 &&
                isAllZero(hands,1,7) && isAllZero(hands,10,16) && isAllZero(hands,19,25);
    }

    private boolean isLianQiDui(int[] hands) {
        //noQingYiSe, noBuQiuRen, noDanDiaoJiang, noMenQianQing, noQiDui,noQiuYiMen, noWuZi
        int count = 0;
        for (int i=0; i<9; i++){
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
        return hands[27] >= 3 && hands[28] >= 3 && hands[29] >= 3 && hands[30] >= 3;
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
