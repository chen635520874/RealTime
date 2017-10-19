package com.example.chen.realtime.bean;

import com.google.gson.annotations.SerializedName;


/**
 * Created by Administrator on 2017/10/19.
 */

public class RoomLine {
    /**
     *
     * room_lines : [{"name":"tx","flv":{"3":{"name":"标清","src":"http://flv3.quanmin.tv/live/3766_326745_550.flv"},"4":{"name":"高清","src":"http://flv3.quanmin.tv/live/3766_326745_900.flv"},"5":{"name":"超清","src":"http://flv3.quanmin.tv/live/3766_326745.flv"},"main_mobile":3,"main_pc":4},"hls":{"3":{"name":"标清","src":"http://hls3.quanmin.tv/live/3766_326745_550.m3u8"},"4":{"name":"高清","src":"http://hls3.quanmin.tv/live/3766_326745_900.m3u8"},"5":{"name":"超清","src":"http://hls3.quanmin.tv/live/3766_326745.m3u8"},"main_mobile":3,"main_pc":4},"def_mobile":"flv","def_pc":"flv","v":"1"},{"name":"ws","flv":{"3":{"name":"标清","src":"http://flv.quanmin.tv/live/326745_L3.flv"},"4":{"name":"高清","src":"http://flv.quanmin.tv/live/326745_L4.flv"},"5":{"name":"超清","src":"http://flv.quanmin.tv/live/326745.flv"},"main_mobile":3,"main_pc":4},"hls":{"3":{"name":"标清","src":"http://hls.quanmin.tv/live/326745_L3/playlist.m3u8"},"4":{"name":"高清","src":"http://hls.quanmin.tv/live/326745_L4/playlist.m3u8"},"5":{"name":"超清","src":"http://hls.quanmin.tv/live/326745/playlist.m3u8"},"main_mobile":3,"main_pc":4},"def_mobile":"flv","def_pc":"flv","v":"1"},{"name":"bd","flv":{"3":{"name":"标清","src":"http://flv2.quanmin.tv/live/326745-L3.flv"},"4":{"name":"高清","src":"http://flv2.quanmin.tv/live/326745-L4.flv"},"5":{"name":"超清","src":"http://flv2.quanmin.tv/live/326745.flv"},"main_mobile":3,"main_pc":4},"hls":{"3":{"name":"标清","src":"http://hls2.quanmin.tv/live/326745-L3.m3u8"},"4":{"name":"高清","src":"http://hls2.quanmin.tv/live/326745-L4.m3u8"},"5":{"name":"超清","src":"http://hls2.quanmin.tv/live/326745.m3u8"},"main_mobile":3,"main_pc":4},"def_mobile":"flv","def_pc":"flv","v":"1"},{"name":"ali","flv":{"3":{"name":"标清","src":"http://liveal.quanmin.tv/live/326745_quanmin576.flv"},"4":{"name":"高清","src":"http://liveal.quanmin.tv/live/326745_quanmin720.flv"},"5":{"name":"超清","src":"http://liveal.quanmin.tv/live/326745.flv"},"main_mobile":3,"main_pc":4},"hls":{"3":{"name":"标清","src":"http://liveal.quanmin.tv/live/326745_quanmin576.m3u8"},"4":{"name":"高清","src":"http://liveal.quanmin.tv/live/326745_quanmin720.m3u8"},"5":{"name":"超清","src":"http://liveal.quanmin.tv/live/326745.m3u8"},"main_mobile":3,"main_pc":4},"def_mobile":"flv","def_pc":"flv","v":"1"},{"name":"qn","flv":{"3":{"name":"标清","src":"http://flv5.quanmin.tv/live/326745@quanmin_sd_720p.flv"},"4":{"name":"高清","src":"http://flv5.quanmin.tv/live/326745@quanmin_hd_720p.flv"},"5":{"name":"超清","src":"http://flv5.quanmin.tv/live/326745.flv"},"main_mobile":3,"main_pc":4},"hls":{"3":{"name":"标清","src":"http://flv5.quanmin.tv/live/326745@quanmin_sd_720p.m3u8"},"4":{"name":"高清","src":"http://flv5.quanmin.tv/live/326745@quanmin_hd_720p.m3u8"},"5":{"name":"超清","src":"http://flv5.quanmin.tv/live/326745.m3u8"},"main_mobile":3,"main_pc":4},"def_mobile":"flv","def_pc":"flv","v":"1"}]
     *
     * name : tx
     * flv : {"3":{"name":"标清","src":"http://flv3.quanmin.tv/live/3766_326745_550.flv"},"4":{"name":"高清","src":"http://flv3.quanmin.tv/live/3766_326745_900.flv"},"5":{"name":"超清","src":"http://flv3.quanmin.tv/live/3766_326745.flv"},"main_mobile":3,"main_pc":4}
     * hls : {"3":{"name":"标清","src":"http://hls3.quanmin.tv/live/3766_326745_550.m3u8"},"4":{"name":"高清","src":"http://hls3.quanmin.tv/live/3766_326745_900.m3u8"},"5":{"name":"超清","src":"http://hls3.quanmin.tv/live/3766_326745.m3u8"},"main_mobile":3,"main_pc":4}
     * def_mobile : flv
     * def_pc : flv
     * v : 1
     */

    private String name;

    private FlvBean flv;
    /**
     * 3 : {"name":"标清","src":"http://flv3.quanmin.tv/live/3766_326745_550.flv"}
     * 4 : {"name":"高清","src":"http://flv3.quanmin.tv/live/3766_326745_900.flv"}
     * 5 : {"name":"超清","src":"http://flv3.quanmin.tv/live/3766_326745.flv"}
     * main_mobile : 3
     * main_pc : 4
     */

    private HlsBean hls;
    /**
     * 3 : {"name":"标清","src":"http://hls3.quanmin.tv/live/3766_326745_550.m3u8"}
     * 4 : {"name":"高清","src":"http://hls3.quanmin.tv/live/3766_326745_900.m3u8"}
     * 5 : {"name":"超清","src":"http://hls3.quanmin.tv/live/3766_326745.m3u8"}
     * main_mobile : 3
     * main_pc : 4
     */

    private String def_mobile;
    private String def_pc;
    private String v;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FlvBean getFlv() {
        return flv;
    }

    public void setFlv(FlvBean flv) {
        this.flv = flv;
    }

    public HlsBean getHls() {
        return hls;
    }

    public void setHls(HlsBean hls) {
        this.hls = hls;
    }

    public String getDef_mobile() {
        return def_mobile;
    }

    public void setDef_mobile(String def_mobile) {
        this.def_mobile = def_mobile;
    }

    public String getDef_pc() {
        return def_pc;
    }

    public void setDef_pc(String def_pc) {
        this.def_pc = def_pc;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    public static class FlvBean{
        /**
         * 3 : {"name":"标清","src":"http://flv3.quanmin.tv/live/3766_326745_550.flv"}
         * 4 : {"name":"高清","src":"http://flv3.quanmin.tv/live/3766_326745_900.flv"}
         * 5 : {"name":"超清","src":"http://flv3.quanmin.tv/live/3766_326745.flv"}
         * main_mobile : 3
         * main_pc : 4
         */

        /**
         * 3 : {"name":"标清","src":"http://flv3.quanmin.tv/live/3766_326745_550.flv"}
         */
        @SerializedName("3")
        private StreamSrc  value3;

        /**
         *  4 : {"name":"高清","src":"http://flv3.quanmin.tv/live/3766_326745_900.flv"}
         */
        @SerializedName("4")
        private StreamSrc value4;

        /**
         * 5 : {"name":"超清","src":"http://flv3.quanmin.tv/live/3766_326745.flv"}
         */
        @SerializedName("5")
        private StreamSrc value5;

        private int main_mobile;
        private int main_pc;

        public StreamSrc getValue(boolean isShowing){
            if (isShowing && value5 != null){
                return value5;
            }
            if (value4 != null){
                return value4;
            }
            if (value5 != null){
                return value5;
            }
            return value3;

        }

        public StreamSrc getValue3() {
            return value3;
        }

        public void setValue3(StreamSrc value3) {
            this.value3 = value3;
        }

        public StreamSrc getValue4() {
            return value4;
        }

        public void setValue4(StreamSrc value4) {
            this.value4 = value4;
        }

        public StreamSrc getValue5() {
            return value5;
        }

        public void setValue5(StreamSrc value5) {
            this.value5 = value5;
        }

        public int getMain_mobile() {
            return main_mobile;
        }

        public void setMain_mobile(int main_mobile) {
            this.main_mobile = main_mobile;
        }

        public int getMain_pc() {
            return main_pc;
        }

        public void setMain_pc(int main_pc) {
            this.main_pc = main_pc;
        }
        @Override
        public String toString() {
            return "FlvBean{" +
                    "value3=" + value3 +
                    ", value4=" + value4 +
                    ", value5=" + value5 +
                    ", main_mobile=" + main_mobile +
                    ", main_pc=" + main_pc +
                    '}';
        }
    }

    public static class HlsBean{
        /**
         * 3 : {"name":"标清","src":"http://hls3.quanmin.tv/live/3766_326745_550.m3u8"}
         * 4 : {"name":"高清","src":"http://hls3.quanmin.tv/live/3766_326745_900.m3u8"}
         * 5 : {"name":"超清","src":"http://hls3.quanmin.tv/live/3766_326745.m3u8"}
         * main_mobile : 3
         * main_pc : 4
         */

        /**
         *  3 : {"name":"标清","src":"http://hls3.quanmin.tv/live/3766_326745_550.m3u8"}
         */
        @SerializedName("3")
        private StreamSrc value3;

        /**
         * 4 : {"name":"高清","src":"http://hls3.quanmin.tv/live/3766_326745_900.m3u8"}
         */
        @SerializedName("4")
        private StreamSrc value4;

        /**
         * 5 : {"name":"超清","src":"http://hls3.quanmin.tv/live/3766_326745.m3u8"
         */
        private StreamSrc value5;

        private int main_mobile ;

        private int main_pc;

        public StreamSrc getValue(boolean isShowing){
            if (isShowing && value5!= null){
                return value5;
            }
            if (value4 != null){
                return value4;
            }
            if (value5!= null){
                return value5;
            }
            return value3;
        }

        public StreamSrc getValue3() {
            return value3;
        }

        public void setValue3(StreamSrc value3) {
            this.value3 = value3;
        }

        public StreamSrc getValue4() {
            return value4;
        }

        public void setValue4(StreamSrc value4) {
            this.value4 = value4;
        }

        public StreamSrc getValue5() {
            return value5;
        }

        public void setValue5(StreamSrc value5) {
            this.value5 = value5;
        }

        public int getMain_mobile() {
            return main_mobile;
        }

        public void setMain_mobile(int main_mobile) {
            this.main_mobile = main_mobile;
        }

        public int getMain_pc() {
            return main_pc;
        }

        public void setMain_pc(int main_pc) {
            this.main_pc = main_pc;
        }
        @Override
        public String toString() {
            return "HlsBean{" +
                    "value3=" + value3 +
                    ", value4=" + value4 +
                    ", value5=" + value5 +
                    ", main_mobile=" + main_mobile +
                    ", main_pc=" + main_pc +
                    '}';
        }
    }
    @Override
    public String toString() {
        return "RoomLine{" +
                "name='" + name + '\'' +
                ", flv=" + flv +
                ", hls=" + hls +
                ", def_mobile='" + def_mobile + '\'' +
                ", def_pc='" + def_pc + '\'' +
                ", v='" + v + '\'' +
                '}';
    }
}
