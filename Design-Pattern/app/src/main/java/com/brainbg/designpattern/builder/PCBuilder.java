package com.brainbg.designpattern.builder;

/**
 * <pre>
 *     author : Brainbg
 *     e-mail : brainbg@foxmail
 *     time   : 2019/08/05
 *     desc   :建造者模式
 * </pre>
 */
public class PCBuilder {
    private String cpu;
    private String mainBoard;
    private String graphicsCard;
    private String hardDisk;

    private PCBuilder(Builder builder) {
        this.cpu = builder.cpu;
        this.mainBoard = builder.mainBoard;
        this.graphicsCard = builder.graphicsCard;
        this.hardDisk = builder.hardDisk;
    }

    public static class Builder {

        private String cpu;
        private String mainBoard;
        private String graphicsCard;
        private String hardDisk;

        public Builder addCPU(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder addMainboard(String mainBoard) {
            this.mainBoard = mainBoard;
            return this;
        }

        public Builder addGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Builder addHardDisk(String hardDisk) {
            this.hardDisk = hardDisk;
            return this;
        }

        public PCBuilder build() {
            return new PCBuilder(this);
        }

    }

    @Override
    public String toString() {
        return "CPU:" + this.cpu + "  主板:" + this.mainBoard + "  显卡:" + this.graphicsCard + "  硬盘:" + this.hardDisk + "\n";
    }

    public PCBuilder execute(StringCallback callback) {
        if (callback != null) {
            if (!cpu.isEmpty() && !mainBoard.isEmpty() && !graphicsCard.isEmpty() && !hardDisk.isEmpty()) {
                callback.onSuccess(toString());
            } else {
                callback.onError("组装失败! \n");
            }
        }
        return this;
    }
}