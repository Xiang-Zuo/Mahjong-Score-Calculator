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
                this.hands[32] = this.hands[31] + 1;
            }else if (card.endsWith("B")){
                this.hands[33] = this.hands[31] + 1;
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
        }else if(isSiAnKe){
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
        if (isWuFanHu(hands)){
            fanXings.add("WuFanHu");
            paiXingResult.add("无番胡");
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

    }

    private boolean isLianQiDui(int[] hands) {
    }

    private boolean isSiGang(int[] hands) {
        int count = 0;
        for (int i= 0; i < hands.length; i++){
            if (hands[i] == 4)
                count++;
        }
        return count == 4;
    }

    private boolean isJiuLianBaoDeng(int[] hands) {
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
        return hands[10] + hands[11] + hands[12] + hands[14] + hands[16] + hands[32] == 14;
    }

    private boolean isDaSanYuan(int[] hands) {
        return hands[31] >= 3 && hands[32] >= 3 && hands[33] >= 3;
    }

    private boolean isDaSiXi(int[] hands) {
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

}
