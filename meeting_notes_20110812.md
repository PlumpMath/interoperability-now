**Attendees**: Sven, Micah, Chase, Russ

## Action items: ##
  * Update xliff:doc spec based on feedback by Fri. Aug 19 (Micah)
  * Send spreadsheet of consolidated TIPP feedback to the team by Tues. Aug 16 (Chase)
  * Update TIPP spec based on feedback by Fri. Aug 19 (Chase)
  * Follow up with Gabor on Kilgray participation by Fri. Aug 19 (Sven)
  * Meet to discuss more detailed development plan including fallback demo approach by Fri. Aug 12 (Timo, Sven, Chase)
  * Work on draft presentation by Fri. Aug 26 (Micah)
  * Send bios to Peter for presentation by Fri. Aug 19 (Sven, Micah)

## Meeting notes: ##

### 1) Beta review feedback ###
  * We have feedback from everyone, we need another week to review latest feedback from David and incorporate changes
  * Next round of review
    * Open up to more reviewers - Arle, Alan, technical staff at participating companies, other tool makers (Andre @ XTM, Swordfish, Shigamichi on WorldServer team at SDL, Andrew Pimlott, QA Distiller)
    * Tentatively target sending out for next round of review in a week or so
  * Key feedback points
    * xliff:doc
      * Potential blockers: group, x/g vs. ph
      * Terminology - Don't make a new format, use an established standard like TBX
      * Include project metadata?
    * TIPP
      * Minor issues: directory structure, more granular resource status (some items completed, but not others)
      * Project metadata seems more intuitive here
      * Carrier for file formats other than xliff:doc?
        * Need to interlink content, package, and communication
        * Transport raw source files? Is that interoperable?
        * Decision:
          * Build up to it, add future intent to package spec
          * Just xliff:doc for now
      * Make it clear what is supported now. E.g., terminology is future.
      * Add Micah's use cases for including TMX and TBX in the payload to the future roadmap
      * Chase will send out spreadsheet of feedback and make package changes based on feedback
  * Feedback decisions
    * Decide on `<group>` usage (cf. Yves and Christian feedback) - Leave it as-is
    * Decide on `/<g> vs <ph> (or <ph> + ept/bpt)`.
      * Illegal to add markup to attributes
      * Workaround via lookup table or encoding
      * We could respond with encoding argument
      * We will investigate `<g>/ vs <ept><bpt><it><ph>` for placeholders. If we DO move to encapsulating ones, we will only use `<ph>`, not ept/bpt/it
    * Decide on `<note>` element: according to XLIFF 1.2 rules, we can't add dx: attributes to the note element. (why?!). So, we either give up on some of our info, or we create a new `<dx:note>` element.
      * You can't add another namespace to note element
      * Reuse from and annotates? OR use custom element
      * We'll stick with notes and drop dx:refers to
      * We should investigate the UTX format for terminology
        * Tab delimited format
        * Lightweight, used for MT
        * Serves as a lookup table

### 2) Development status ###
  * Will Ontram, Kilgray, and GlobalSight all be able to contribute development time to support the demo?
    * Sven will follow-up with Gabor on Kilgray participation
    * Sven, Timo, and Chase meeting today
    * If Kilgray can't contribute, need to discuss backup plan. Perhaps OKAPI.

### 3) Presentation ###
  * Micah will work on it week of Aug 22
  * Need to send bios to Peter