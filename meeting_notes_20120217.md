**Attendees:** Sven, Micah, Chase

## Action Items ##
  * Come to a final decision on the file structure issues by Feb 24 (All)

## Background ##
The entire call was a discussion about package structure issues raised during the week over email:
  * Files in the package may contain internal references to each other that make assumptions about file hierarchy structure
    * The notable use case for this is preview (where the problem is rampant), but Chase is concerned other similar use cases will emerge
  * Splitting up files into the sections for TIPP could screw this up
  * The underlying question is: does TIPP describe a file structure, or is it merely a carrier for an external structure?
  * Chase had proposed an alternative where sections merely because per-file "type" attributes, and the package just became a container to transport a file structure from one place to another.

## Notes ##
  * What kind of preview are we talking about?  Medtronic does two kinds:
    * List view of TUs, including inline images
    * Context view, which renders the HTML page
  * Sven makes a couple arguments about the relationship between preview and the rest of the process -- in effect, arguing that preview is a special case
    * He'd hate to mess up the core structure by hiding the XLIFF under thousands of other files
      * Chase: Although this is really only a concern for human readability, as any machine interface could still select by type
    * Preview is arguably optional functionality.  Does TIPP even need to track all the supplemental files that it uses?
      * Furthermore, is it better to insulate TIPP success/failure from potential failures resulting from preview functionality?
    * One possibility would be to omit the preview files from the manifest (other than a directory where they live).  Another would be to put them within another nested zip.
  * Chase: Here are the goals I keep coming back to:
    * Limit the direct bindings between TIPP and Xliff:doc (ie, TIPP should not assume XLIFF:doc behavior directly), and preferably vice-versa as well.
    * In general, try to avoid making assumptions about the file structure required by things inside the package, as I don't think it's possible to anticipate everything.
  * Micah: Agrees with limiting direct TIPP`<->`XLIFF:doc dependencies.  However, the Preview feature of xliff:doc can impose restrictions on how its files are structured, and that may give us an out
    * eg, all preview files need to live within some directory (for example, preview/), and as part of prep for xliff:doc preview all those files must be converted as needed to work that way.
      * Observations that nested references in preview are quite likely - chained CSS or JS includes, etc
  * Back to file structures in the TIPP
    * Brief discussion of the flat structure proposal.  It has a problem in that there's no place for "output" files, unless they replace the source (with a different type attribute).  Sven notes that for debugging/diagnostic reasons, it's better to keep source available.
  * Micah proposes splitting the package into two trees: source and target, sort of like how we had it before
    * bilingual file (only 1?)
    * source/ and target/
    * references/, containing TMs, TBs, etc, listed individually
    * preview data in a single zip file

## Micah's notes on his package proposal ##
### Structure ###
  * /source
    * source files that need processing (only if you don't do XLIFF:doc/bilingual)
  * /target
    * mirror of source, if this package had something in /source, and if you generated a target from non-bilingual source.
  * /preview.zip
    * put all original files, in their original structure. only the translateable bits will be overwritten (possibly) by translation tools
  * /references
    * put TMs, previous translations, TBs, whatever. (single call outs)
    * put any reference FILES in a single zip (1 call out to the zip)
  * /bilingual.xlf (1 bilingual per TIPP)

### Dependencies ###
  * XLIFF:doc would need a rule that preview files must be generated in the /preview folder (as root), following the path stored in the `<file>` element (if you wanted to take advantage of graphics and other resources. If you don't plan to offer that level of preview, then you can generate your preview files whereever you like.
  * in manifest:
    * source files are called out on file-by-file basis (see Chase's recent flat file example)
    * preview files: 1 call out to the .zip file.
  * references:
    * 1 call out to the .zip file for any documents (previous translations of documents, similar documents, explanatory documents, and other non-machine-processeable information)
    * individual call outs to TMs, TBs, and other things we need to track, because a machine may need to process them.

## Questions that need answering ##
  * Can the TIPP contain files that are not referenced in the manifest?
    * If the answer "yes" is scary, we can do an end-run by having another zip as a package object to contain the loose files.
    * There is a threat to "reliability" either way.  Without complete accounting, there is limited diagnostic/validation support.  However, a very long manifest increases risk of some inconsequential problem killing the whole package.
  * Are we agreed that a TIPP can have only one bilingual file?
    * Sven notes this may be required by some tools.  (eg, WorldServer operates this way.)