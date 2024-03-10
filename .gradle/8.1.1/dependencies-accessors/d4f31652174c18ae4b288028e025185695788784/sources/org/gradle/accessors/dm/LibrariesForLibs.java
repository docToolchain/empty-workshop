package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import org.gradle.api.internal.attributes.ImmutableAttributesFactory;
import org.gradle.api.internal.artifacts.dsl.CapabilityNotationParser;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the `libs` extension.
 */
@NonNullApi
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final AsciidoctorLibraryAccessors laccForAsciidoctorLibraryAccessors = new AsciidoctorLibraryAccessors(owner);
    private final AsciidoctorjLibraryAccessors laccForAsciidoctorjLibraryAccessors = new AsciidoctorjLibraryAccessors(owner);
    private final ByteLibraryAccessors laccForByteLibraryAccessors = new ByteLibraryAccessors(owner);
    private final GroovyLibraryAccessors laccForGroovyLibraryAccessors = new GroovyLibraryAccessors(owner);
    private final HtmlLibraryAccessors laccForHtmlLibraryAccessors = new HtmlLibraryAccessors(owner);
    private final HttpLibraryAccessors laccForHttpLibraryAccessors = new HttpLibraryAccessors(owner);
    private final MarkdownLibraryAccessors laccForMarkdownLibraryAccessors = new MarkdownLibraryAccessors(owner);
    private final OpenaiLibraryAccessors laccForOpenaiLibraryAccessors = new OpenaiLibraryAccessors(owner);
    private final OpenapiLibraryAccessors laccForOpenapiLibraryAccessors = new OpenapiLibraryAccessors(owner);
    private final PoiLibraryAccessors laccForPoiLibraryAccessors = new PoiLibraryAccessors(owner);
    private final SpockLibraryAccessors laccForSpockLibraryAccessors = new SpockLibraryAccessors(owner);
    private final StructurizrLibraryAccessors laccForStructurizrLibraryAccessors = new StructurizrLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

        /**
         * Creates a dependency provider for guava (com.google.guava:guava)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getGuava() {
            return create("guava");
    }

        /**
         * Creates a dependency provider for jsoup (org.jsoup:jsoup)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJsoup() {
            return create("jsoup");
    }

        /**
         * Creates a dependency provider for junit (org.junit.jupiter:junit-jupiter-api)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJunit() {
            return create("junit");
    }

        /**
         * Creates a dependency provider for pebble (io.pebbletemplates:pebble)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getPebble() {
            return create("pebble");
    }

    /**
     * Returns the group of libraries at asciidoctor
     */
    public AsciidoctorLibraryAccessors getAsciidoctor() {
        return laccForAsciidoctorLibraryAccessors;
    }

    /**
     * Returns the group of libraries at asciidoctorj
     */
    public AsciidoctorjLibraryAccessors getAsciidoctorj() {
        return laccForAsciidoctorjLibraryAccessors;
    }

    /**
     * Returns the group of libraries at byte
     */
    public ByteLibraryAccessors getByte() {
        return laccForByteLibraryAccessors;
    }

    /**
     * Returns the group of libraries at groovy
     */
    public GroovyLibraryAccessors getGroovy() {
        return laccForGroovyLibraryAccessors;
    }

    /**
     * Returns the group of libraries at html
     */
    public HtmlLibraryAccessors getHtml() {
        return laccForHtmlLibraryAccessors;
    }

    /**
     * Returns the group of libraries at http
     */
    public HttpLibraryAccessors getHttp() {
        return laccForHttpLibraryAccessors;
    }

    /**
     * Returns the group of libraries at markdown
     */
    public MarkdownLibraryAccessors getMarkdown() {
        return laccForMarkdownLibraryAccessors;
    }

    /**
     * Returns the group of libraries at openai
     */
    public OpenaiLibraryAccessors getOpenai() {
        return laccForOpenaiLibraryAccessors;
    }

    /**
     * Returns the group of libraries at openapi
     */
    public OpenapiLibraryAccessors getOpenapi() {
        return laccForOpenapiLibraryAccessors;
    }

    /**
     * Returns the group of libraries at poi
     */
    public PoiLibraryAccessors getPoi() {
        return laccForPoiLibraryAccessors;
    }

    /**
     * Returns the group of libraries at spock
     */
    public SpockLibraryAccessors getSpock() {
        return laccForSpockLibraryAccessors;
    }

    /**
     * Returns the group of libraries at structurizr
     */
    public StructurizrLibraryAccessors getStructurizr() {
        return laccForStructurizrLibraryAccessors;
    }

    /**
     * Returns the group of versions at versions
     */
    public VersionAccessors getVersions() {
        return vaccForVersionAccessors;
    }

    /**
     * Returns the group of bundles at bundles
     */
    public BundleAccessors getBundles() {
        return baccForBundleAccessors;
    }

    /**
     * Returns the group of plugins at plugins
     */
    public PluginAccessors getPlugins() {
        return paccForPluginAccessors;
    }

    public static class AsciidoctorLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public AsciidoctorLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for asciidoctor (org.asciidoctor:asciidoctor-gradle-jvm)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() {
                return create("asciidoctor");
        }

            /**
             * Creates a dependency provider for gems (org.asciidoctor:asciidoctor-gradle-jvm-gems)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getGems() {
                return create("asciidoctor.gems");
        }

            /**
             * Creates a dependency provider for pdf (org.asciidoctor:asciidoctor-gradle-jvm-pdf)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getPdf() {
                return create("asciidoctor.pdf");
        }

            /**
             * Creates a dependency provider for slides (org.asciidoctor:asciidoctor-gradle-jvm-slides)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getSlides() {
                return create("asciidoctor.slides");
        }

    }

    public static class AsciidoctorjLibraryAccessors extends SubDependencyFactory {

        public AsciidoctorjLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for diagram (org.asciidoctor:asciidoctorj-diagram)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getDiagram() {
                return create("asciidoctorj.diagram");
        }

    }

    public static class ByteLibraryAccessors extends SubDependencyFactory {

        public ByteLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for buddy (net.bytebuddy:byte-buddy)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getBuddy() {
                return create("byte.buddy");
        }

    }

    public static class GroovyLibraryAccessors extends SubDependencyFactory {

        public GroovyLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for all (org.codehaus.groovy:groovy-all)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getAll() {
                return create("groovy.all");
        }

            /**
             * Creates a dependency provider for xml (org.codehaus.groovy:groovy-xml)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getXml() {
                return create("groovy.xml");
        }

    }

    public static class HtmlLibraryAccessors extends SubDependencyFactory {
        private final HtmlSanityLibraryAccessors laccForHtmlSanityLibraryAccessors = new HtmlSanityLibraryAccessors(owner);

        public HtmlLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at html.sanity
         */
        public HtmlSanityLibraryAccessors getSanity() {
            return laccForHtmlSanityLibraryAccessors;
        }

    }

    public static class HtmlSanityLibraryAccessors extends SubDependencyFactory {

        public HtmlSanityLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for check (org.aim42.htmlSanityCheck:org.aim42.htmlSanityCheck.gradle.plugin)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCheck() {
                return create("html.sanity.check");
        }

    }

    public static class HttpLibraryAccessors extends SubDependencyFactory {

        public HttpLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for client (org.apache.httpcomponents.client5:httpclient5)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getClient() {
                return create("http.client");
        }

    }

    public static class MarkdownLibraryAccessors extends SubDependencyFactory {
        private final MarkdownToLibraryAccessors laccForMarkdownToLibraryAccessors = new MarkdownToLibraryAccessors(owner);

        public MarkdownLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at markdown.to
         */
        public MarkdownToLibraryAccessors getTo() {
            return laccForMarkdownToLibraryAccessors;
        }

    }

    public static class MarkdownToLibraryAccessors extends SubDependencyFactory {

        public MarkdownToLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for asciidoc (nl.jworks.markdown_to_asciidoc:markdown_to_asciidoc)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getAsciidoc() {
                return create("markdown.to.asciidoc");
        }

    }

    public static class OpenaiLibraryAccessors extends SubDependencyFactory {
        private final OpenaiGpt3LibraryAccessors laccForOpenaiGpt3LibraryAccessors = new OpenaiGpt3LibraryAccessors(owner);

        public OpenaiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at openai.gpt3
         */
        public OpenaiGpt3LibraryAccessors getGpt3() {
            return laccForOpenaiGpt3LibraryAccessors;
        }

    }

    public static class OpenaiGpt3LibraryAccessors extends SubDependencyFactory {

        public OpenaiGpt3LibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for service (com.theokanning.openai-gpt3-java:service)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getService() {
                return create("openai.gpt3.service");
        }

    }

    public static class OpenapiLibraryAccessors extends SubDependencyFactory {

        public OpenapiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for generator (org.openapitools:openapi-generator-gradle-plugin)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getGenerator() {
                return create("openapi.generator");
        }

    }

    public static class PoiLibraryAccessors extends SubDependencyFactory {

        public PoiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for ooxml (org.apache.poi:poi-ooxml)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getOoxml() {
                return create("poi.ooxml");
        }

    }

    public static class SpockLibraryAccessors extends SubDependencyFactory {

        public SpockLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (org.spockframework:spock-core)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() {
                return create("spock.core");
        }

            /**
             * Creates a dependency provider for reports (com.athaydes:spock-reports)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getReports() {
                return create("spock.reports");
        }

    }

    public static class StructurizrLibraryAccessors extends SubDependencyFactory {
        private final StructurizrD2LibraryAccessors laccForStructurizrD2LibraryAccessors = new StructurizrD2LibraryAccessors(owner);

        public StructurizrLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for dsl (com.structurizr:structurizr-dsl)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getDsl() {
                return create("structurizr.dsl");
        }

            /**
             * Creates a dependency provider for export (com.structurizr:structurizr-export)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getExport() {
                return create("structurizr.export");
        }

            /**
             * Creates a dependency provider for graphviz (com.structurizr:structurizr-graphviz)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getGraphviz() {
                return create("structurizr.graphviz");
        }

        /**
         * Returns the group of libraries at structurizr.d2
         */
        public StructurizrD2LibraryAccessors getD2() {
            return laccForStructurizrD2LibraryAccessors;
        }

    }

    public static class StructurizrD2LibraryAccessors extends SubDependencyFactory {

        public StructurizrD2LibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for exporter (io.github.goto1134:structurizr-d2-exporter)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getExporter() {
                return create("structurizr.d2.exporter");
        }

    }

    public static class VersionAccessors extends VersionFactory  {

        private final ApacheVersionAccessors vaccForApacheVersionAccessors = new ApacheVersionAccessors(providers, config);
        private final AsciidoctorVersionAccessors vaccForAsciidoctorVersionAccessors = new AsciidoctorVersionAccessors(providers, config);
        private final AsciidoctorjVersionAccessors vaccForAsciidoctorjVersionAccessors = new AsciidoctorjVersionAccessors(providers, config);
        private final ByteVersionAccessors vaccForByteVersionAccessors = new ByteVersionAccessors(providers, config);
        private final HttpVersionAccessors vaccForHttpVersionAccessors = new HttpVersionAccessors(providers, config);
        private final MarkdownVersionAccessors vaccForMarkdownVersionAccessors = new MarkdownVersionAccessors(providers, config);
        private final OpenaiVersionAccessors vaccForOpenaiVersionAccessors = new OpenaiVersionAccessors(providers, config);
        private final SpockVersionAccessors vaccForSpockVersionAccessors = new SpockVersionAccessors(providers, config);
        private final StructurizrVersionAccessors vaccForStructurizrVersionAccessors = new StructurizrVersionAccessors(providers, config);
        private final UndercouchVersionAccessors vaccForUndercouchVersionAccessors = new UndercouchVersionAccessors(providers, config);
        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: groovy (3.0.13)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getGroovy() { return getVersion("groovy"); }

            /**
             * Returns the version associated to this alias: guava (33.0.0-jre)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getGuava() { return getVersion("guava"); }

            /**
             * Returns the version associated to this alias: htmlSanityCheck (1.1.6)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getHtmlSanityCheck() { return getVersion("htmlSanityCheck"); }

            /**
             * Returns the version associated to this alias: jbake (5.5.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getJbake() { return getVersion("jbake"); }

            /**
             * Returns the version associated to this alias: jsoup (1.16.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getJsoup() { return getVersion("jsoup"); }

            /**
             * Returns the version associated to this alias: junit (5.9.3)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getJunit() { return getVersion("junit"); }

            /**
             * Returns the version associated to this alias: openapi (6.6.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getOpenapi() { return getVersion("openapi"); }

            /**
             * Returns the version associated to this alias: pebble (3.2.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getPebble() { return getVersion("pebble"); }

            /**
             * Returns the version associated to this alias: versions (0.46.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getVersions() { return getVersion("versions"); }

        /**
         * Returns the group of versions at versions.apache
         */
        public ApacheVersionAccessors getApache() {
            return vaccForApacheVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.asciidoctor
         */
        public AsciidoctorVersionAccessors getAsciidoctor() {
            return vaccForAsciidoctorVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.asciidoctorj
         */
        public AsciidoctorjVersionAccessors getAsciidoctorj() {
            return vaccForAsciidoctorjVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.byte
         */
        public ByteVersionAccessors getByte() {
            return vaccForByteVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.http
         */
        public HttpVersionAccessors getHttp() {
            return vaccForHttpVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.markdown
         */
        public MarkdownVersionAccessors getMarkdown() {
            return vaccForMarkdownVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.openai
         */
        public OpenaiVersionAccessors getOpenai() {
            return vaccForOpenaiVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.spock
         */
        public SpockVersionAccessors getSpock() {
            return vaccForSpockVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.structurizr
         */
        public StructurizrVersionAccessors getStructurizr() {
            return vaccForStructurizrVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.undercouch
         */
        public UndercouchVersionAccessors getUndercouch() {
            return vaccForUndercouchVersionAccessors;
        }

    }

    public static class ApacheVersionAccessors extends VersionFactory  {

        public ApacheVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: apache.poi (5.2.3)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getPoi() { return getVersion("apache.poi"); }

    }

    public static class AsciidoctorVersionAccessors extends VersionFactory  {

        public AsciidoctorVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: asciidoctor.jvm (4.0.0-alpha.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getJvm() { return getVersion("asciidoctor.jvm"); }

    }

    public static class AsciidoctorjVersionAccessors extends VersionFactory  {

        public AsciidoctorjVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: asciidoctorj.diagram (2.2.7)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getDiagram() { return getVersion("asciidoctorj.diagram"); }

    }

    public static class ByteVersionAccessors extends VersionFactory  {

        public ByteVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: byte.buddy (1.14.4)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getBuddy() { return getVersion("byte.buddy"); }

    }

    public static class HttpVersionAccessors extends VersionFactory  {

        public HttpVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: http.client (5.3)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getClient() { return getVersion("http.client"); }

    }

    public static class MarkdownVersionAccessors extends VersionFactory  {

        private final MarkdownToVersionAccessors vaccForMarkdownToVersionAccessors = new MarkdownToVersionAccessors(providers, config);
        public MarkdownVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.markdown.to
         */
        public MarkdownToVersionAccessors getTo() {
            return vaccForMarkdownToVersionAccessors;
        }

    }

    public static class MarkdownToVersionAccessors extends VersionFactory  {

        public MarkdownToVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: markdown.to.asciidoc (1.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getAsciidoc() { return getVersion("markdown.to.asciidoc"); }

    }

    public static class OpenaiVersionAccessors extends VersionFactory  {

        public OpenaiVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: openai.gpt3 (0.12.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getGpt3() { return getVersion("openai.gpt3"); }

    }

    public static class SpockVersionAccessors extends VersionFactory  implements VersionNotationSupplier {

        public SpockVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the version associated to this alias: spock (2.3-groovy-3.0)
         * If the version is a rich version and that its not expressible as a
         * single version string, then an empty string is returned.
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> asProvider() { return getVersion("spock"); }

            /**
             * Returns the version associated to this alias: spock.reports (2.3.2-groovy-3.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getReports() { return getVersion("spock.reports"); }

    }

    public static class StructurizrVersionAccessors extends VersionFactory  {

        private final StructurizrD2VersionAccessors vaccForStructurizrD2VersionAccessors = new StructurizrD2VersionAccessors(providers, config);
        public StructurizrVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: structurizr.dsl (1.29.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getDsl() { return getVersion("structurizr.dsl"); }

            /**
             * Returns the version associated to this alias: structurizr.export (1.14.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getExport() { return getVersion("structurizr.export"); }

            /**
             * Returns the version associated to this alias: structurizr.graphviz (2.0.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getGraphviz() { return getVersion("structurizr.graphviz"); }

        /**
         * Returns the group of versions at versions.structurizr.d2
         */
        public StructurizrD2VersionAccessors getD2() {
            return vaccForStructurizrD2VersionAccessors;
        }

    }

    public static class StructurizrD2VersionAccessors extends VersionFactory  {

        public StructurizrD2VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: structurizr.d2.exporter (1.2.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getExporter() { return getVersion("structurizr.d2.exporter"); }

    }

    public static class UndercouchVersionAccessors extends VersionFactory  {

        public UndercouchVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: undercouch.download (5.4.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getDownload() { return getVersion("undercouch.download"); }

    }

    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

    }

    public static class PluginAccessors extends PluginFactory {
        private final JbakePluginAccessors paccForJbakePluginAccessors = new JbakePluginAccessors(providers, config);
        private final OpenapiPluginAccessors paccForOpenapiPluginAccessors = new OpenapiPluginAccessors(providers, config);
        private final UndercouchPluginAccessors paccForUndercouchPluginAccessors = new UndercouchPluginAccessors(providers, config);

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for htmlSanityCheck to the plugin id 'org.aim42.htmlSanityCheck'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getHtmlSanityCheck() { return createPlugin("htmlSanityCheck"); }

            /**
             * Creates a plugin provider for versions to the plugin id 'com.github.ben-manes.versions'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getVersions() { return createPlugin("versions"); }

        /**
         * Returns the group of plugins at plugins.jbake
         */
        public JbakePluginAccessors getJbake() {
            return paccForJbakePluginAccessors;
        }

        /**
         * Returns the group of plugins at plugins.openapi
         */
        public OpenapiPluginAccessors getOpenapi() {
            return paccForOpenapiPluginAccessors;
        }

        /**
         * Returns the group of plugins at plugins.undercouch
         */
        public UndercouchPluginAccessors getUndercouch() {
            return paccForUndercouchPluginAccessors;
        }

    }

    public static class JbakePluginAccessors extends PluginFactory {

        public JbakePluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for jbake.site to the plugin id 'org.jbake.site'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getSite() { return createPlugin("jbake.site"); }

    }

    public static class OpenapiPluginAccessors extends PluginFactory {

        public OpenapiPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for openapi.generator to the plugin id 'org.openapi.generator'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getGenerator() { return createPlugin("openapi.generator"); }

    }

    public static class UndercouchPluginAccessors extends PluginFactory {

        public UndercouchPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for undercouch.download to the plugin id 'de.undercouch.download'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getDownload() { return createPlugin("undercouch.download"); }

    }

}
