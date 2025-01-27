VTKExamples Administrators have write access to the [git repository](https://github.com/lorensen/VTKExamples). If you are a VTKExamples User [go here](/Instructions/ForUsers) or a VTKExamples Developer [go here](/Instructions/ForDevelopers).

# Organization of the VTKExamples Repository

The VTKExamples are stored in a [git repository](https://github.com/lorensen/VTKExamples.git) hosted at [github.com](http://www.github.com/). The repository contains several types of files.

All example source code, descriptions, test data, and test baselines are stored in the *src/* tree.

## VTKExamples Repository

The major elements of the tree are:

``` bash
|-- VTKExamples
  |-- CMakeLists.txt   # To build all of the examples
  |-- _layouts         # Contains _default.html
  |-- custom_theme     # tweaks to the material theme
  |-- mkdocs.yml       # config file for MkDocs
  |-- src              # all of the content to create site/
    |-- SyncSiteWithRepo.sh  # master script to update site/
    |-- Admin
    |   |-- ScrapeRepo       # script to create docs/
    |   |-- VTKCMakeLists    # template for Cxx examples
    |   |-- VTKQtCMakeLists  # template for Cxx Qt
    |   |-- sitemap.xml      # generated sitemap
    |   |-- sitemapGenerator # site map generator
    |-- Artifacts       # Additional images, docs, etc.
    |-- Instructions    # Documentation
    |-- LANGUAGE.md     # Summary file for language
    |-- LANGUAGE        # Language examples
    |   |-- TOPIC
    |-- Tarballs     # Tar files for each Cxx example
    |-- Testing
    |   |-- Baseline # Baselines for examples
    |   |   |-- LANGUAGE
    |   |   |   |-- TOPIC
    |   |-- Data    # Data for examples
    |-- stylesheets
        |-- extra.css # mkdocs search config
  |-- site  # static web pages generated by mkdocs
```

## Look and Feel
A priority in moving from the wiki media [VTK Wiki Examples](http://www.vtk.org/Wiki/VTK/Examples) to the Github pages [VTKExamples](https://lorensen.github.io/VTKExamples/site/) was to provide a modern, familiar look and feel. We also wanted to support tablet and mobile platforms. We chose [MkDocs](http://www.mkdocs.org/) because it generated static HTML pages that can be hosted anywhere.

<img style="border:2px solid beige;float:center" src="https://github.com/lorensen/VTKExamples/blob/master/src/Artifacts/OldVersusNew.png?raw=true" />

### [MkDocs](http://www.mkdocs.org/)
#### Installing MkDocs
MkDocs is a python package and can be installed using `pip`;

```bash
pip install mkdocs
```
#### Configuring MkDocs
The *mkdocs.yml* file contains the configuration parameters
```bash
site_name: VTKExamples
theme: material
site_url: https://lorensen.github.io/VTKExamples/site/
repo_name: lorensen/VTKExamples
repo_url: https://github.com/lorensen/VTKExamples
theme_dir: custom_theme
markdown_extensions:
  - admonition
  - codehilite(guess_lang=false)
  - toc(permalink=true)
google_analytics:
  -  'UA-3660134-4'
  -  'auto'
extra_css:
  -  'stylesheets/extra.css'
copyright: '<font color=#666>Content is available under </font><a href="https://creativecommons.org/licenses/by/2.5/" title="Attribution2.5">Attribution2.5</a> <font color=#666>unless otherwise noted.</font>'
```
#### Markdown Extensions
A number of markdown extensions are available.
##### [admonition](http://squidfunk.github.io/mkdocs-material/extensions/admonition/)
Admonitions are specially marked "topics" that can appear anywhere an ordinary body element can. They contain arbitrary body elements. Typically, an admonition is rendered as an offset block in a document, sometimes outlined or shaded, with a title matching the admonition type.
For example:

!!! note
    This is a note or seealso admonition

!!! summary
    This is a summary or todo admonition

!!! info
    This is an info or todo admonition

!!! tip
    This is a tip, hint or important admonition

!!! success
    This is a success, check or done admonition

!!! question
    This is a question,help faq admonition

!!! warning
    This is a warning, caution or attention admonition

!!! failure
    This is a failure, fail or missing admonition

!!! danger
    This is a danger or error admonition

!!! bug
    This is a bug admonition

!!! quote
    This is a quote or cite admonition

!!! cite
    This is a cite admonition

##### [codehilite](http://squidfunk.github.io/mkdocs-material/extensions/codehilite/)
The codehilite extension highlights code depending on the language.

##### toc
The toc extension generates a table of contents, like the one at the right of this page.

### [MkDocs Materials theme](http://squidfunk.github.io/mkdocs-material/)
The Materials theme is built using Google's [Material Design](https://material.io/guidelines/) guidelines. It offers a unified experience across platforms. The look and feel is a familiar one.

#### Configuring Materials
The materials theme is selected using the *material* keyword in the *mkdocs.yml* file.

## [Google Analytics](https://analytics.google.com/)
Google Analytics tracks the site usage, providing lots of useful statistics. To have Google Analytics track web usage, you need to register the URL with the Google Analytics System. After registration, an HTML snippet is provided to include on every web page to be tracked.

### Configuring Google Analytics

The *google_analytics* keyword in the *mkdocs.yml" file specifies the google analytics unique code for this web site. The *custom_theme/main.html* file defines the metadata for the google site verification:
HTML
<meta name="google-site-verification" content="8hi6AHNlzKOmFDV4W8tLmySODRzQvtqMEIfZdc3WTLA" />
```
## [Google Custom Search Engine](https://cse.google.com/cse/)
The overall look and feel are established at [https://cse.google.com/cse/](https://cse.google.com/cse/). After setting up the search engine, you can get the code to add to the web pages.

```javascript
<script>
  (function() {
    var cx = '015419652359195128492:0lkxso1wcym';
    var gcse = document.createElement('script');
    gcse.type = 'text/javascript';
    gcse.async = true;
    gcse.src = 'https://cse.google.com/cse.js?cx=' + cx;
    var s = document.getElementsByTagName('script')[0];
    s.parentNode.insertBefore(gcse, s);
  })();
</script>
```

### Configuring GCSE
The code is added to [custom_theme/main.html](https://github.com/lorensen/VTKExamples/blob/master/custom_theme/main.html).
```html
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<gcse:searchbox-only>Search</gcse:searchbox-only>
```
### Implementing GCSE
The search box is added to the web pages by adding the gcse search box html
``` html
    <gcse:searchbox-only>Search</gcse:searchbox-only>
```
## Performance
### [Lazy Image Loading](https://davidwalsh.name/lazyload-image-fade)

The first implementation had problems loading the [Cxx summary](/Cxx). The number of embedded images exceeded the throttle limits of Github. A lazy image load solution solved the problem. Now, images are only loaded if they appear in the browser window.

The Lazy Image Loading is implemented in javascript. The javascript is stored in *custom_theme/main.html*. It uses a clever *trick*. Images that should be lazy loaded use a *<img>* tag with a *class=lazy* and attribute *data_src*. If the image is in the viewport, the *data_src* is removed, and the image renders.

### Tiny URLs

The VTKExamples web pages have many URL's that link to images and VTK doxygen pages. The long length of these URLs can increase page load times, especially on the language summary pages. 

[http://tinyurl.com](http://tinyurl.com) provides a service to map the long URL's into shorted URLs. There is a python package, [tinyurl](https://pypi.python.org/pypi/TinyUrl/) that converts the long URL's. Unfortunately, this process is slow. To speed up the process, we cache the long/short URLs in a file [src/Admin/TinyUrlCache](https://github.com/lorensen/VTKExamples/raw/master/src/Admin/TinyUrlCache). *ScrapeRepo* uses this cache to only convert URLs that are not in the cache. *ScrapeRepo* updates the cache after each run.

*tinyurl* must be installed:
```bash
pip install tinyurl
```
### Minify HTML pages

*mkdocs* generates HTML pages from the markdown files in *doc*. These pages have lots of white space. We use the python package [htmlmin](https://htmlmin.readthedocs.io/en/latest/) to compress the generated HTML. The compressed pages are about 30% smaller after running *htmlmin*. We use the command line to process each *index.html* file in *site/*.

*htmlmin* must be installed:
```bash
pip install htmlmin
```
## Administrator Tasks

### [ScrapeRepo](https://github.com/lorensen/VTKExamples/blob/master/src/Admin/ScrapeRepo)

<img style="border:2px solid beige;float:center" src="https://github.com/lorensen/VTKExamples/blob/master/src/Artifacts/ScrapeRepo.png?raw=true" />

Given a *RepositoryDir*, *DocDir* and a *RepositoryUrl*, *ScrapeRepo* proceeds as follows:

1. Adds thumbnails to the *Cxx.md* and *Python.md* summary pages.  A thumbnail is added if a _src/Testing/Baseline/_**LANG**/**TOPIC**/_Test_**EXAMPLE**_.png_ image exists for the example.

2. Copies non-example *.md* files like *Cxx.md* and *Python.md* files to *docs/*.

3. For each example source file create _docs/_**LANG**/**TOPIC**/**EXAMPLE**_.md_ file that contains:
    1. If _src/Testing/Baseline/_**LANG**/**TOPIC**_/Test_**EXAMPLE**_.png_ exists add the image
    2. If a _src/_**LANG**/**TOPIC**/**EXAMPLE**_.md_ description file exists, insert the description
    3. Insert the source code from _src/_**LANG**/**TOPIC**/**EXAMPLE**.**EXTENSION**

4. For each Cxx source file
    1. If _Cxx/_**TOPIC**/**EXAMPLE**_.cmake_ exists, add it as the CMakeLists section of the _.md_ file, otherwise, fill in the *VTKCMakelists* template, including the files listed in the optional _src/Cxx/_**TOPIC**/**EXAMPLE**_.extras_ file.

4. For each Cxx source file, create a _src/Tarballs/_**EXAMPLE**_.tar_ file containing the source and _CMakeLists.txt_ file.

## SyncSiteWithRepo
The *SyncSiteWithRepo.sh* shell script executes all of the steps to update the static website. It proceeds as follow:

1. Makes sure the site is up

2. Pulls updates from the [master repository](https://github.com/lorensen/VTKExamples).

3. Pulls updates from the [src/Tarballs repository](https://github.com/lorensen/VTKWikiExamplesTarballs)

     The tarballs are kept in a separate repository to reduce the size of the main repository. They are only accessed from the individual example pages.

4. Creates the coverage files

     The [src/Admin/VTKClassesUsedInExamples.py](https://github.com/lorensen/VTKExamples/blob/master/src/Admin/VTKClassesUsedInExamples.py) python script generates two tables for each language. One table list each class and what classes it uses. The second table lists the classes that are not used in any example.

4. Wipes the *docs* directory

     The *docs* directory contains all of the md and HTML files for the site. A clean directory prevents old files from being used.

5. Runs the [ScrapeRepo script](https://lorensen.github.io/VTKExamples/site/Instructions/ForAdministrators/#scraperepo)

     populate the *docs* directory.

6. Checks for a successful scrape

     This sanity check sees if a reasonable number of files have Pbeen updated.

7. Copies the *src/stylesheets* directory ino *docs/stylesheets*

8. Copies the sitemap.xml file

     This file is updated periodically by [sitemapGenerator](https://github.com/lorensen/VTKExamples/blob/master/src/Admin/sitemapGenerator)

9. Minify the HTML

10. Process any modified added or deleted files
11. Update the tarballs

12. Push the changes

     After a *short* time GitHub will update the Github pages.

## How to Become an Administrator
