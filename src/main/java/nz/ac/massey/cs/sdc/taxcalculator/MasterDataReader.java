package nz.ac.massey.cs.sdc.taxcalculator;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility to read tax brackets.
 * @author jens dietrich
 */
public class MasterDataReader {
    public static TaxBracket[] getTaxBrackets() {
        BasicConfigurator.configure();
        Logger logger = Logger.getLogger(MasterDataReader.class);

        String taxbracketDefs = "taxbrackets.json";
        try {
            List<TaxBracket> brackets = new ArrayList<TaxBracket>();
            logger.info("importing tax brackets from " + new File(taxbracketDefs).getAbsolutePath());
            FileInputStream in = new FileInputStream(taxbracketDefs);
            JSONTokener tokener = new JSONTokener(in);
            JSONArray jsonArray = new JSONArray(tokener);
            for (int i=0;i<jsonArray.length();i++) {
                JSONObject jsonObj = jsonArray.getJSONObject(i);
                TaxBracket bracket = new TaxBracket(
                    jsonObj.getDouble("start"),
                    jsonObj.getDouble("end")==-1?Double.MAX_VALUE:jsonObj.getDouble("end"),
                    jsonObj.getDouble("rate")
                );
                brackets.add(bracket);
            }
            return brackets.toArray(new TaxBracket[jsonArray.length()]);
        }
        catch (Exception x) {
            logger.error("exception importing tax brackets from " + new File(taxbracketDefs).getAbsolutePath(),x);
            throw new IllegalStateException("Cannot initialise data needed");
        }
    }
}
