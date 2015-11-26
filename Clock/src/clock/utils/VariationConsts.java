package clock.utils;

public class VariationConsts {

    public enum BackgroundColor {
        WHITE("white"),
        BLACK("black"),
        RED("red"),
        BLUE("blue");

        public String value;
        private BackgroundColor(String value){
            this.value = value;
        }
    }

    public enum BorderColor {
        WHITE("white"),
        BLACK("black"),
        RED("red"),
        BLUE("blue");

        public String value;
        private BorderColor(String value){
            this.value = value;
        }
    }

    public enum ClockType {
        ANALOG("analog"),
        DIGITAL("digital");

        public String value;
        private ClockType(String value){
            this.value = value;
        }
    }
}
