package dna;
public class DNA{
    final private double massA = 135.128;
    final private double massC = 111.103;
    final private double massG = 151.128;
    final private double massT = 125.107;
    final private double massJunk = 100.000;
    private String sequence;
    public DNA(String nucleotide){
        int count = 0;
        for(int i = 0; i < nucleotide.length(); i++){
            if((nucleotide.substring(i,i+1).equals("A"))
            ||(nucleotide.substring(i,i+1).equals("C"))
            ||(nucleotide.substring(i,i+1).equals("G"))
            ||(nucleotide.substring(i,i+1).equals("T"))){
                count++; 
            }
        }
        if(count % 3 != 0){
            throw new IllegalArgumentException("Invalid DNA sequence");
        }
        sequence = nucleotide;
    }
    public boolean isProtein(){
        String sequenceNoJunk = "";
        int CGTotalMass = 0;
        for(int i = 0; i < sequence.length();i++){
            if(sequence.substring(i, i + 1).equals("C")){
                CGTotalMass += massC;
                sequenceNoJunk += sequence.substring(i, i + 1);}
            else if(sequence.substring(i, i + 1).equals("G")){
                CGTotalMass += massG;
                sequenceNoJunk += sequence.substring(i, i + 1);
            }
            
            else if(sequence.substring(i,i+1).equals("A")  
                || sequence.substring(i,i+1).equals("T")){
                    sequenceNoJunk += sequence.substring(i,i+1);
            }
        }
            
        if(!sequenceNoJunk.substring(0,3).equals("ATG")){
            return false;
        }
            int seqlen = sequenceNoJunk.length();
            if(!sequenceNoJunk.substring(seqlen-3,seqlen).equals("TAA")
            &&!sequenceNoJunk.substring(seqlen-3,seqlen).equals("TAG")
            &&!(sequenceNoJunk.substring(seqlen-3,seqlen).equals("TGA"))){
                return false;
            }
            if(CGTotalMass /totalMass() < 0.3){
                return false;
            }
            return true;
    }  
    public double totalMass(){
        double totalMass = 0.000;
        for(int i = 0; i < sequence.length(); i++){
            if(sequence.substring(i, i+1).equals("A")){
                totalMass += massA;
            } 
            else if(sequence.substring(i, i+1).equals("C")){
                totalMass += massC;
            }
            else if(sequence.substring(i, i+1).equals("G")){
                totalMass += massG;
            }
            else if(sequence.substring(i,i+1).equals("T")){
                totalMass += massT;
            }
            else{
                totalMass += massJunk;
            }
        }
        return totalMass;
    }
    public int nucleotideCount(char nucleotide){
        int count = 0;
        for(int i = 0; i < sequence.length(); i++){
            if(sequence.charAt(i) == (nucleotide)){
                count++;
            }
        }
        return count;
    }
}

// TODO: Implement the DNA datatype from scratch!
// Use the test cases to guide you.