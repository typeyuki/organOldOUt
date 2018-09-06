package com.organOld.oService.model;

import java.util.List;

/**
 *
 */
public class PersonalInfoModel extends MenModel {
   private OldsModel oldman;
   private LinkmanModel linkman;
   private OrganOldsModel organ;//机构养老
   private List<OrganOldsModel> community;//社区养老
   private List<HomeOldsModel> home;//家庭养老

   public OldsModel getOldman() {
      return oldman;
   }

   public void setOldman(OldsModel oldman) {
      this.oldman = oldman;
   }

   public LinkmanModel getLinkman() {
      return linkman;
   }

   public void setLinkman(LinkmanModel linkman) {
      this.linkman = linkman;
   }

   public OrganOldsModel getOrgan() {
      return organ;
   }

   public void setOrgan(OrganOldsModel organ) {
      this.organ = organ;
   }

   public List<OrganOldsModel> getCommunity() {
      return community;
   }

   public void setCommunity(List<OrganOldsModel> community) {
      this.community = community;
   }

   public List<HomeOldsModel> getHome() {
      return home;
   }

   public void setHome(List<HomeOldsModel> home) {
      this.home = home;
   }
}
