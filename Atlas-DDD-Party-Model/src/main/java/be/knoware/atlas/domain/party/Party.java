package be.knoware.atlas.domain.party;

import be.knoware.atlas.domain.communication.CommunicationPoint;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by ovanekem on 22/12/15.
 */
public class Party {
    private long id;
    private String denomination;
    private Date startDate;
    private Date endDate;

    public List<CommunicationPoint> getCommunicationPointList() {
        return communicationPointList;
    }

    public void setCommunicationPointList(List<CommunicationPoint> communicationPointList) {
        this.communicationPointList = communicationPointList;
    }

    private List<CommunicationPoint> communicationPointList;

    public Party() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }


    public Party(Integer id) {

    }


}
