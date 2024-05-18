class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> hs = new HashSet<>();
        for (String email : emails) {
            char[] em = email.toCharArray();
            int atSignId = -1;
            boolean plusPresent = false;
            String domain = "";
            for (int i = 0; i < em.length; i++) {
                if (em[i] == '@') {
                    atSignId = i;
                } else if (em[i] == '+') {
                    plusPresent = true;
                }
                if (atSignId == -1 && !plusPresent) {
                    if (em[i] != '.') {
                        domain += "" + em[i];
                    }
                }
            }
            hs.add(domain + email.substring(atSignId));
        }
        return hs.size();
    }
}
