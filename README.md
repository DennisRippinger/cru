# CRU - Cloud Resource Updater

> **_NOTE:_** Currently in Development, not functioning.
> Published to seek out comments.

CRUs purpose is to provide an IaC GitOps Bot users, which consumes sizing recommendations from different providers, such as AWS or KubeCost.
Their recommendations are meaningful but often forgotten in the daily business and usually only applied once in a while when someone complains about the costs.
This bot should provide periodic Merge Requests with changes to our IaC.

## K8s

The sources in IaC can vary in each setup.
Hence CRU strives to work with comment needles and a location config map.
A config could look like this:

```yaml
k8s:
  location:
    - path: "kustomize/overlays/prod/patch-resources.yaml"
      cluster: "prod-cluster"
      namespace: "prod-namespace"
    - path: "kustomize/overlays/non-prod/patch-resources.yaml"
      cluster: "non-prod-cluster"
      namespace: "non-prod-namespace"
```

Where a Needed could look like this:

```yaml
      containers:
        - name: container_one
          resources:
            requests:
              # cru: container=container_one cluster=Cluster1
              cpu: 670m
              # cru: container=container_one cluster=Cluster1
              memory: 1021Mi
```

The simple name-value pairs within the comment can/should overwrite configs from the map.

## AWS

Like with Kubecost, does AWS offer recommendations regarding cloud usage.
Similar to KubeCost CRU could facilitate these recommendations into MRs for Terraform or CloudFormation with a similar approach.
