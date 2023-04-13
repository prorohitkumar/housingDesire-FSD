import { DesignDetail } from './design-details/design-detail';
export class Designer {

    constructor(
        designerId:String,
        name:String,
        pin_code:String,
        city:String,
       mobile_no:String,
       shopname:String,
       email:String,
       DesignDetail:any,
       firstname:String,
       lastname:String){

    }
    /*
    private String designerId;

    private String name;

    private String pin_code;

    private String city;

    private String mobile_no;

    private String shopname;

    private String email;
//    @OneToMany(targetEntity = designdetail.class , cascade = CascadeType.ALL)
//    @JoinColumn(name = "cp_fk" ,referencedColumnName = "designerid")
    private List<designdetail> DesignDetail;


    private String firstname;

    private String lastname;
    */
}
