// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package oop.class_problems.week5;

public class PatientProfile {
   private String patientId;
   private String name;
   private boolean discharged;
   private String lockerPin;

   public PatientProfile() {
      this((String)null, (String)null);
   }

   public PatientProfile(String var1) {
      this((String)null, var1);
   }

   public PatientProfile(String var1, String var2) {
      this.patientId = var1;
      this.name = var2;
      this.discharged = false;
   }

   public String getPatientId() {
      return this.patientId;
   }

   public void setPatientId(String var1) {
      if (this.patientId == null) {
         this.patientId = var1;
      }

   }

   public String getName() {
      return this.name;
   }

   public void setName(String var1) {
      this.name = var1;
   }

   public boolean isDischarged() {
      return this.discharged;
   }

   public void setDischarged(boolean var1) {
      this.discharged = var1;
   }

   public void setLockerPin(String var1) {
      if (var1 != null && var1.matches("\\d{4,6}")) {
         this.lockerPin = var1;
      }

   }

   public static void main(String[] var0) {
      PatientProfile var1 = new PatientProfile("Arjun Iyer");
      System.out.println(var1.getPatientId());
      PatientProfile var2 = new PatientProfile("MT2026-0142", "Arjun Iyer");
      System.out.println(var2.getPatientId());
      PatientProfile var3 = new PatientProfile();
      var3.setPatientId("MT2026-0142");
      var3.setPatientId("HACKED-0000");
      System.out.println(var3.getPatientId());
      var3.setLockerPin("1234");
      System.out.println("PatientProfile tested successfully");
   }
}
