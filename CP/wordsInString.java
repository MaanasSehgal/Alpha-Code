public class wordsInString {
    public static void main(String[] args) {
        String str = "As reliance on fossil fuels continues to rise, prices have increased due to diminishing oil supplies and higher emissions, leading to the promotion of green energy sources like alternative renewable fuels. Biofuel, a substitute for compression ignition (CI) fuel, can improve engine performance when combined with low heat rejection (LHR) technology. LHR engines enhance the thermal efficiency of CI engines by reducing heat loss to the environment. In this study, a ceramic material (Partially Stabilized Zirconium) with a thickness of approximately 0.5 mm was applied to the piston crown using plasma spraying. The performance of safflower methyl ester (SAME) in the LHR engine, along with retarded timing (RT), was compared to a standard engine. The results indicate that the LHR engine’s brake thermal efficiency is higher than that of the standard engine. Additionally, the emission levels of CO and unburned hydrocarbons (UBHC) are lower in the LHR engine compared to the standard engine. Selection and peer review under the responsibility of the scientific committee of the International Conference on Advancements in Materials and Manufacturing. 2023 Elsevier Ltd. All rights reserved.";

        int wordCount = 1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                wordCount++;
            }
        }

        System.out.println(wordCount);

    }
}