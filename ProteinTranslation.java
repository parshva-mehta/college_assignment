import java.util.Arrays;

public class ProteinTranslation{
    public static void main(String[] args) {
        String input = args[0];
        String RNA = transcription(input);
        translation(RNA);
    }

    public static String transcription (String DNA){
        char[] RNA = new char[DNA.length()];
        for(int i = 0; i < DNA.length(); i++){
            switch (DNA.charAt(i)) {
                case 'A':
                    RNA[i] = 'U';
                    break;
                case 'C':
                    RNA[i] = 'G';
                    break;
                case 'G':
                    RNA[i] = 'C';
                    break;
                case 'T':
                    RNA[i] = 'A';
                default:
                    break;
            }
        }
        String RNA_String = new String(RNA);
        return RNA_String;
    }
    public static void translation(String RNA){
        //divide up rest of string into 3 bases each
        String usefulDNA = findStartCodon(RNA);
        String[] individualCodons = new String[usefulDNA.length()];
        int j = 0;

        for(int i = 0; i < usefulDNA.length()-3; i+=3){
            individualCodons[j] = (""+ usefulDNA.charAt(i) + usefulDNA.charAt(i+1) + usefulDNA.charAt(i+2));
            j++;
        }
        String codon;
        
        for(int k = 0; k < individualCodons.length; k++){
            codon = individualCodons[k];
            //System.out.print(codon + ":"); 
            if(codon == "UGA" || codon == "UAA" || codon == "UAG"){
                break;
            }
            else if(codon == null){
                break;
            }
            else if(codon.length() < 3){
                break;
            }
            else{
                aminoAcid(codon);
            }
        }
    }
    public static String findStartCodon(String RNA){ //add the stop codon thing here 
        int length = RNA.length();
        int i;
        for(i = 0; i < length-2; i++){
            if(RNA.charAt(i) == 'A' && RNA.charAt(i+1) == 'U' && RNA.charAt(i+2) == 'G'){
                break;
            }
        }

        char[] tempCharArr = RNA.toCharArray();
        char[] resultingRNA = Arrays.copyOfRange(tempCharArr, i, tempCharArr.length);
        String functionalRNA = new String(resultingRNA);
        return functionalRNA;
         
    }
    public static void aminoAcid(String codon){

            //Methionine
            if(codon.equals("AUG")){
                System.out.print("Met ");
            }
            //Alanine
            if(codon.equals("GCA") || codon.equals("GCC") || codon.equals("GCG") || codon.equals("GCU")){
                System.out.print("Ala ");
            }
            //Arginine
            if(codon.equals("CGA") || codon.equals("CGC") || codon.equals("CGG") || codon.equals("CGU") || codon.equals("AGA") || codon.equals("AGG")){
                System.out.print("Arg ");
            }
            //Asparagine
            if(codon.equals("AAU") || codon.equals("AAC")){
                System.out.print("Asn ");
            }
            //Aspartate
            if(codon.equals("GAU") || codon.equals("GAC")){
                System.out.print("Asp ");
            }
            //Cystine
            if(codon.equals("UGU") || codon.equals("UGC")){
                System.out.print("Cys ");
            }
            //Glutamine
            if(codon.equals("CAA") || codon.equals("CAG")){
                System.out.print("Gln ");
            }
            //Glutamate
            if(codon.equals("GAA") || codon.equals("GAG")){
                System.out.print("Glu ");
            }
            //Glycine
            if(codon.equals("GGA") || codon.equals("GGC") || codon.equals("GGG") || codon.equals("GGU")){
                System.out.print("Gly ");
            }
            //Histidine
            if(codon.equals("CAU") || codon.equals("CAC")){
                System.out.print("His ");
            }
            //Isoleucine
            if(codon.equals("AAU") || codon.equals("AUC") || codon.equals("AUA")){
                System.out.print("Ile ");
            }
            //Leucine
            if(codon.equals("CUA") || codon.equals("CUC") || codon.equals("CUG") || codon.equals("CUU") || codon.equals("UUA") || codon.equals("UUG")){
                System.out.print("Lys ");
            }
            //Phenylalanine
            if(codon.equals("UUU") || codon.equals("UUC")){
                System.out.print("Phe ");
            }
            //Proline
            if(codon.equals("CCA") || codon.equals("CCC") || codon.equals("CCG") || codon.equals("CCU")){
                System.out.print("Pro ");
            }
            //Serine
            if(codon.equals("UCA") || codon.equals("UCC") || codon.equals("UCG") || codon.equals("UCU") || codon.equals("AGU") || codon.equals("AGC")){
                System.out.print("Ser ");
            }
            //Threonine
            if(codon.equals("ACA") || codon.equals("ACC") || codon.equals("ACG") || codon.equals("ACU")){
                System.out.print("Thr ");
            }
            //Tryptophan
            if(codon.equals("UGG")){
                System.out.print("Trp ");
            }
            //Tyrosine
            if(codon.equals("UAU") || codon.equals("UAC")){
                System.out.print("Tyr ");
            }
            //Valine
            if(codon.equals("GUA") || codon.equals("GUC") || codon.equals("GUG") || codon.equals("GUU")){
                System.out.print("Val ");
            }
    }
}