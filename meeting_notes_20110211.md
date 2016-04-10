**Present:** Sven, Gabor, Micah, Yan, Chase, Russ

**Apologies:** Peter, Derek

**Russell Taga**
  * Yan introduced Russell Taga, Senior Director of Product Development at Welocalize, to the team.

**Beta Reader**
  * Will invite Beta Reader of the manifesto, Christian Lieske, Yves Savourel and David Filip.

**Licensing**
  * GlobalSight is under Apache 2 license
  * Two separate items - 1)Specifications: Keep it strict, 2) Reference implementation (with open source code): Keep it loose
  * Sven is paying the lawyers.

**Compliance**
  * Two separate levels - 1) XLIFF:Doc creator, 2) XLIFF:Doc consumer/processor
  * We probably need to develop some tools to validate implementation against specifications.
  * Sven suggest to have a master thesis student to create a testing tools.
  * Cannot test everything programmatically.  Probably need to provide some test scripts for people to validate with.  For example, are the segments merged correctly.

**Interoperability Package**
  * Gabor will review the document and provide feedback this weekend

**XLIFF:Doc / HTML Preview**
  * Ok to specify path (relative or absolute) for CSS and XSLT files.
  * We cannot require that XLIFF:doc always be used within the interoperability package.
  * We need a mechanism for including files that don’t get translated, but are necessary to create a preview, inside the interoperability package.  Micah will write that up.
  * Need ways to report and trap error messages during XSLT preview.
  * Revisiting idea of one source file per xliff.  Decision: we will re-write 1 file per XLIFF to be 1 document (gabor: "content unit") per xliff (1 docx per xliff, 1 package of xml + svg per xliff for a cms origin, ex.).
  * Consensus on where the tool should get the CSS and XSLT files for generic XLIFF:doc.  1)Use the server copy by default, 2)The CAT tool can use its own, 3)If the CAT tool doesn’t write one, we will have a reference online for download.

**Implementation and Sample Files**
  * We need example files to start with implementation
  * Every group on phone had engineer/architects already on the call, except ONTRAM. Sven will identify someone.
  * Micah will make some sample files
  * Sven will then work up some sample XSLT/CSS