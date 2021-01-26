package com.muc.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class EMSPBaseRequest
{
    @SerializedName("OperatorID")
    private String OperatorID;
    @SerializedName("Data")
    private String Data;
    @SerializedName("TimeStamp")
    private String TimeStamp;
    @SerializedName("Seq")
    private String Seq;
    @SerializedName("Sig")
    private String Sig;
}
