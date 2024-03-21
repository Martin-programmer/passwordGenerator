public class Generator {
    private int passwordLength;
    private boolean areIncludedUppercaseLetters;
    private boolean areIncludedLowercaseLetters;
    private boolean areIncludedNumbers;
    private boolean areIncludedSymbols;

    public Generator(int passwordLength, boolean areIncludedUppercaseLetters, boolean areIncludedLowercaseLetters
    , boolean areIncludedNumbers, boolean areIncludedSymbols) {
        this.passwordLength = passwordLength;
        this.areIncludedUppercaseLetters = areIncludedUppercaseLetters;
        this.areIncludedLowercaseLetters = areIncludedLowercaseLetters;
        this.areIncludedNumbers = areIncludedNumbers;
        this.areIncludedSymbols = areIncludedSymbols;
    }

    public String generate(){
        int numberOfContainedCriteria = getNumOfContainedCriteria(areIncludedUppercaseLetters,
                areIncludedLowercaseLetters, areIncludedNumbers, areIncludedSymbols);
        int lengthPerCriteria = passwordLength/numberOfContainedCriteria;
        StringBuilder stringBuilder = new StringBuilder();
        generateCharactersForPassword(stringBuilder, lengthPerCriteria);

        if (stringBuilder.length() < passwordLength){
            addCharactersToFinalString(stringBuilder);
        }
        return RandomiseOrder.random(stringBuilder.toString());
    }

    private void generateCharactersForPassword(StringBuilder stringBuilder, int lengthPerCriteria) {
        if (areIncludedUppercaseLetters){
            stringBuilder.append(Alphabet.generate(lengthPerCriteria,"upperLetters"));
        }
        if (areIncludedLowercaseLetters){
            stringBuilder.append(Alphabet.generate(lengthPerCriteria,"lowerLetters"));
        }
        if (areIncludedNumbers){
            stringBuilder.append(Alphabet.generate(lengthPerCriteria,"numbers"));
        }
        if (areIncludedSymbols){
            stringBuilder.append(Alphabet.generate(lengthPerCriteria,"symbols"));
        }
    }

    private void addCharactersToFinalString(StringBuilder stringBuilder) {
        if (areIncludedNumbers){
            stringBuilder.append(Alphabet.generate(passwordLength- stringBuilder.length(),"numbers"));
        }
        if (areIncludedSymbols){
            stringBuilder.append(Alphabet.generate(passwordLength- stringBuilder.length(),"symbols"));
        }
        if (areIncludedUppercaseLetters){
            stringBuilder.append(Alphabet.generate(passwordLength- stringBuilder.length(),"upperLetters"));
        }
        if (areIncludedLowercaseLetters){
            stringBuilder.append(Alphabet.generate(passwordLength- stringBuilder.length(),"lowerLetters"));
        }
    }

    private int getNumOfContainedCriteria(boolean areIncludedUppercaseLetters, boolean areIncludedLowercaseLetters
            , boolean areIncludedNumbers, boolean areIncludedSymbols) {
        int count = 0;
        if (areIncludedUppercaseLetters){
            count++;
        }
        if (areIncludedLowercaseLetters){
            count++;
        }
        if (areIncludedNumbers){
            count++;
        }
        if (areIncludedSymbols){
            count++;
        }
        return count;
    }
}
