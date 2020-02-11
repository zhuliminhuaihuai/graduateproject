//package com.keda.util;
//
//
//import com.jacob.activeX.ActiveXComponent;
//import com.jacob.com.Dispatch;
//import com.jacob.com.Variant;
//import org.junit.Test;
//
//public class VoiceUtil {
//
//
//    /**
//     * @param @param content
//     * @param @param type 设定文件   0:开始，1停止
//     * @return 返回类型：void
//     * @throws
//     * @Title: strat
//     * @Description: 该方法的主要作用：朗读
//     */
//    public static void strat(String content, int type) {
//        // ？？ 这个Sapi.SpVoice是需要安装什么东西吗，感觉平白无故就来了
//        ActiveXComponent sap = new ActiveXComponent("Sapi.SpVoice");
//        // Dispatch是做什么的？
//        Dispatch sapo = sap.getObject();
//
//        if (type == 0) {
//            try {
//                // 音量 0-100
//                sap.setProperty("Volume", new Variant(100));
//                // 语音朗读速度 -10 到 +10
//                sap.setProperty("Rate", new Variant(1.3));
//                Variant defalutVoice = sap.getProperty("Voice");
//
//                Dispatch dispdefaultVoice = defalutVoice.toDispatch();
//                Variant allVoices = Dispatch.call(sapo, "GetVoices");
//                Dispatch dispVoices = allVoices.toDispatch();
//
//                Dispatch setvoice = Dispatch.call(dispVoices, "Item",
//                        new Variant(1)).toDispatch();
//                ActiveXComponent voiceActivex = new ActiveXComponent(
//                        dispdefaultVoice);
//                ActiveXComponent setvoiceActivex = new ActiveXComponent(
//                        setvoice);
//
//                Variant item = Dispatch.call(setvoiceActivex, "GetDescription");
//                // 执行朗读
//                Dispatch.call(sapo, "Speak", new Variant(content));
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
//                sapo.safeRelease();
//                sap.safeRelease();
//            }
//        } else {
//            // 停止
//
//            try {
//                Dispatch.call(sapo, "Speak", new Variant(content), new Variant(
//                        2));
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//                e.printStackTrace();
//            }
//        }
//
//    }
//
//
//    /**
//     * @return 返回类型：void
//     * @throws
//     * @Title: test
//     * @Description: 该方法的主要作用：执行朗读内容
//     */
//    @Test
//    public void test() {
//        strat("夏冬最美", 0);
//    }
//}
