xquery version "1.0-ml";
module namespace custom = "http://www.example/xyz/custom-scripts";
import module namespace spawn = "hhtp://www.xyz/spawn-function" at ".../utils/spawn-function.xqy";


declare variable $SOURCE_TYEP_TRUSTED := "source-trusted";
declare variable $CURRENT_COLLECTION := "current";
declare variable $OFFICE_ENTITY_NAME := "office";
declare variable $LEGAL_ENTITY_NAME := "legalEntity";
declare variable $USA_COUNTRY_RESOURCE := "/country/id/xyz";
declare variable $EXTRACT_MAP := map:new ((
    map:entry('10000220-1074314', 'Not Match'),
    map:entry('10000220-1074314', 'Not Match'),
    map:entry('10000220-1074314', 'Not Match'),
    map:entry('10000220-1074314', 'Not Match'),
    map:entry('10000220-1074314', 'Match')
));

declare variable $URIS := cts:uris((), ("document"),
  cts:and-query((
    cts:collection-query($SOURCE_TYEP_TRUSTED),
    cts:collection-query($CURRENT_COLLECTION),
    cts:element-attribute-range-query(xs:QName("relationship"), xs:QName("resource"), "=",
    custom:getRelationshipsResourcesFromOffices())

  ))
);

declare function custom:getRelationshipsResourcesFromOffices() {
    let $officesResource := custom:getOfficesResourceInCountry($USA_COUNTRY_RESOURCE);


};

declare function custom:getOfficesResourceInCountry($countryHrefs as xs:string*) {
  (custom:getOfficesWithAddressInCountry($countryHrefs), custom:getOfficesWithoutAddressInCountry($countryHrefs))
};

declare function custom:getOfficesWithAddressInCountry($countryHrefs as xs:string*) {
   let $legalEntitiesResourcesMatchingCountry := cts:values(
     cts:element-attribute-reference(xs:QName("legalEntity"), xs:QName("resource")),
     (),
     (),
      cts:and-query((
        cts:collection-query($SOURCE_TYEP_TRUSTED),
        cts:collection-query($LEGAL_ENTITY_NAME),
        cts:collection-query($CURRENT_COLLECTION),
        cts:path-range-query("/legalEntity/summary/countryOfOperations/link/@href/", "=", $countryHrefs)
      ))
     )
     return custom:getOfficesResourcesMatchingLegalEntity($legalEntitiesResourcesMatchingCountry);
   };

declare function custom:getOfficesWithoutAddressInCountry($countryHrefs as xs:string*) {

};

declare function custom:getOfficesResourcesMatchingLegalEntity($institutionHrefs as xs:string*) {
  cts:values(cts:element-attribute-reference(xs:QName("office"), xs:QName("resource")),
  (),
  (),
  cts:and-query((
          cts:collection-query($SOURCE_TYEP_TRUSTED),
          cts:collection-query($LEGAL_ENTITY_NAME),
          cts:collection-query($CURRENT_COLLECTION),
          cts:path-range-query("/office/summary/status", "=", "active"),
          cts:and-query(
            (
                   cts:not-query(
                      cts:element-query(xs:QName("address"), cts:true-query())
                   ),
                  cts:path-range-query("office/summary/institution/link/@href", "=", $institutionHrefs)
            ))
        ))
  )
};