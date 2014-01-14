package lu.snt.serval.pla.sensor;

import lu.snt.serval.pla.userprofile.UserProfile;

/**
 * Created with IntelliJ IDEA.
 * User: assaad.moawad
 * Date: 11/09/13
 * Time: 18:06
 * To change this template use File | Settings | File Templates.
 */
public class AnswerUserProfile extends AnswerBody  {
    public UserProfile getUserProfile() {
        return userProfile;
    }

    UserProfile userProfile;

    public AnswerUserProfile(UserProfile userProfile)
    {
        this.userProfile=userProfile;
    }

}
